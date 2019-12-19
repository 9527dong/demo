import cacheOfAnno.AccountService;
import oldCache.Account;
import oldCache.MyAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCacheTest {

    /**
     * 自定义的缓存方案缺点：
     * 1. 缓存代码和业务代码耦合度太高，如上面的例子，AccountService 中的 getAccountByName（）方法中有了太多缓存的逻辑，不便于维护和变更
     * 2. 不灵活，这种缓存方案不支持按照某种条件的缓存，比如只有某种类型的账号才需要缓存，这种需求会导致代码的变更
     * 3. 缓存的存储这块写的比较死，不能灵活的切换为使用第三方的缓存模块
     *
     */
    @Test
    public void testOldCache() {
        MyAccountService s = new MyAccountService();
        // 开始查询账号
        s.getAccountByName("somebody");// 第一次查询，应该是数据库查询
        s.getAccountByName("somebody");// 第二次查询，应该直接从缓存返回

        s.reload();// 重置缓存
        System.out.println("after reload...");

        s.getAccountByName("somebody");// 应该是数据库查询
        s.getAccountByName("somebody");// 第二次查询，应该直接从缓存返回

    }
    @Test
    public void testCacheOfAnno() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccountByName("somebody");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("second query...");
        s.getAccountByName("somebody");
    }

    /**
     * 测试缓存的更新、清除操作
     */
    @Test
    public void testCacheOfAnnoByUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccountByName("somebody");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.print("second query...");
        s.getAccountByName("somebody");
        System.out.println();

        System.out.println("start testing clear cache...");    // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
        Account account1 = s.getAccountByName("somebody1");
        Account account2 = s.getAccountByName("somebody2");
        // 开始更新其中一个
        account1.setId(1212);
        s.updateAccount(account1);
        s.getAccountByName("somebody1");// 因为被更新了，所以会查询数据库
        s.getAccountByName("somebody2");// 没有更新过，应该走缓存
        s.getAccountByName("somebody1");// 再次查询，应该走缓存
        // 更新所有缓存
        s.reload();
        s.getAccountByName("somebody1");// 应该会查询数据库
        s.getAccountByName("somebody2");// 应该会查询数据库
        s.getAccountByName("somebody1");// 应该走缓存
        s.getAccountByName("somebody2");// 应该走缓存

    }

    /**
     * 按照条件操作缓存
     */
    @Test
    public void testCacheOfAnnoWithCondition() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.print("first query...");
        s.getAccountByNameWithCondition("somebody");// 长度大于 4，不会被缓存
        s.getAccountByNameWithCondition("sbd");// 长度小于 4，会被缓存
        System.out.print("second query...");

        s.getAccountByNameWithCondition("somebody");// 还是查询数据库
        s.getAccountByNameWithCondition("sbd");// 会从缓存返回
    }
    /**
     * 按照条件操作缓存
     */
    @Test
    public void testCacheOfAnnoWithComsopseKey() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");
        s.getAccount("somebody", "123456", true);// 应该查询数据库
        s.getAccount("somebody", "123456", true);// 应该走缓存
        s.getAccount("somebody", "123456", false);// 应该走缓存
        s.getAccount("somebody", "654321", true);// 应该查询数据库
        s.getAccount("somebody", "654321", true);// 应该走缓存
    }
    /**
     * 测试@CachePut注解，可以保证更新方法被执行，且结果一定会被缓存。
     */
    @Test
    public void testCacheOfAnnoWithUpdateCache() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-anno.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");

        Account account = s.getAccountByName("someone");
        account.setPassword("123");
        s.updateAccountAndCache(account);
        account.setPassword("321");
        s.updateAccountAndCache(account);
        account = s.getAccountByName("someone");
        System.out.println(account.getPassword());
    }
    /**
     * 测试@CachePut注解，可以保证更新方法被执行，且结果一定会被缓存。
     */
    @Test
    public void testCacheOfAnnoWithCacheCustom() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "Spring-cache-anno-customer.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");

        Account account = s.getAccountByName("someone");
        System.out.println("passwd="+account.getPassword());
        account = s.getAccountByName("someone");
        System.out.println("passwd="+account.getPassword());
    }

}
