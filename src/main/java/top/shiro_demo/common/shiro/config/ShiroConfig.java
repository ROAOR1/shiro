package top.shiro_demo.common.shiro.config;

import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShiroConfig {

    @Autowired
    private RedisSessionDAO redisSessionDAO;
    @Autowired
    private RedisCacheManager redisCacheManager;

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        chain.addPathDefinition("/401", "anon");
        chain.addPathDefinition("/403", "anon");
        chain.addPathDefinition("/login", "anon");
        chain.addPathDefinition("/error", "anon");
        chain.addPathDefinition("/logout", "anon,logout");
        chain.addPathDefinition("/**", "authc");
        return chain;
    }

    @Bean
    public SessionsSecurityManager securityManager(List<Realm> realms, SessionManager sessionManager){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager(realms);
        manager.setSessionManager(sessionManager);
        //配置会话管理
        manager.setCacheManager(redisCacheManager);
        return manager;
    }

    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO);
        // 不在地址栏显示sessionId
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }
}
