package com.ifarm.console.facade.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 **/
@Configuration
public class ShiroConfiguration {


    @Bean
    public HashedCredentialsMatcher retryLimitHashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager());
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    @Bean
    public CacheManager cacheManager() {
        return null;
    }
}
