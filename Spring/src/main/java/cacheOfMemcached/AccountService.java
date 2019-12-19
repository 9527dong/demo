package cacheOfMemcached;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughMultiCache;
import com.google.code.ssm.api.ReadThroughSingleCache;
import oldCache.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private Account getFromDB(String acctName) {
        System.out.println("real querying db..." + acctName);
        return new Account(acctName);
    }

    private Account getFromDB(String acctName,String password) {
        System.out.println("real querying db..." + acctName);
        return new Account(acctName,password);
    }

    @ReadThroughSingleCache(namespace = "CplxObj", expiration = 3600)
    public Account getAccountByName(@ParameterValueKeyProvider String userName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName,"123456");
    }

    @ReadThroughMultiCache(namespace = "CplxObj", expiration = 3600)
    public List<Account> getAccountsByName(@ParameterValueKeyProvider List<String> userName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(getFromDB(userName.get(0)));
        return accounts;
    }

    @CacheEvict(value = "accountCache", key = "#account.getName()")// 清空 accountCache 缓存
    public void updateAccount(Account account) {
        updateDB(account);
    }

    @CacheEvict(value = "accountCache", allEntries = true)// 清空 accountCache 缓存
    public void reload() {
    }

    private void updateDB(Account account) {
        System.out.println("real update db..." + account.getName());
    }

    @Cacheable(value="accountCache",condition="#userName.length() <= 4")// 缓存名叫 accountCache
    public Account getAccountByNameWithCondition(String userName) {
// 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName);
    }

    @Cacheable(value="accountCache",key="#userName.concat(#password)")
    public Account getAccount(String userName,String password,boolean sendLog) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName,password);

    }

    @CachePut(value="accountCache",key="#account.getName()")// 更新 accountCache 缓存
    public Account updateAccountAndCache(Account account) {
        return updateDBAndReturnValue(account);
    }
    private Account updateDBAndReturnValue(Account account) {
        System.out.println("real updating db..."+account.getName());
        return account;
    }
}
