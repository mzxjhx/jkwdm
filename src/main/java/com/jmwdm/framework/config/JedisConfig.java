package com.jmwdm.framework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/* 
 * HP
 * 2020年6月22日-下午4:04:46
 * 
 */
@Configuration
@PropertySource("classpath:application-db.yml")
@ConfigurationProperties(prefix = "spring")
public class JedisConfig {

	@Value("${host}")
    private  String host ;
	
    @Value("${port}")
    private  int port ;
    
    @Value("${password}")
    private  String auth ;
    
    @Value("${max-idle}")
    private  int maxIdle;
    
    @Value("${max-wait}")
    private  int maxWait;
 
    @Value("${time-out}")
    private  int timeOut;

    @Bean
    public JedisPool jedisPoolFactory() {
        System.out.println("JedisPool注入开始...");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        // 连接耗尽时是否阻塞, false报异常,true阻塞直到超时, 默认true
        //jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认tru
        //jedisPoolConfig.setJmxEnabled(JmxEnabled);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host, port,timeOut,auth);
        System.out.println("JedisPool注入成功...");
        return jedisPool;
    }
}
