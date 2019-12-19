import cacheOfMemcached.AccountService;
import com.google.common.collect.Lists;
import net.spy.memcached.MemcachedClient;
import oldCache.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MemcacheTest {

    @Test
    public void test() throws IOException {
        MemcachedClient c = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
        c.set("someKey",3600,"test");
        Object myObject = c.get("someKey");
        System.out.println(myObject);

        Object myObject2 = c.get("someKey");
        System.out.println(myObject2);
    }


    @Test
    public void testCacheOfAnno() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-memcached.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.println("first query...");
        Account account = s.getAccountByName("somebody1");
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.println("second query...");
        s.getAccountByName("somebody2");
        s.getAccountByName("somebody3");
    }

    @Test
    public void testCacheList() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-cache-memcached.xml");// 加载 spring 配置文件

        AccountService s = (AccountService) context.getBean("accountServiceBean");
        // 第一次查询，应该走数据库
        System.out.println("first query...");
        System.out.println(s.getAccountsByName(Lists.newArrayList("somebody1","somebody2","somebody3")));
        // 第二次查询，应该不查数据库，直接返回缓存的值
        System.out.println("second query...");
        System.out.println(s.getAccountsByName(Lists.newArrayList("somebody1","somebody2","somebody3")));
    }

}
