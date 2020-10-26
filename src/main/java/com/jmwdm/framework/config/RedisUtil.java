package com.jmwdm.framework.config;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/* 
 * HP
 * 2020年6月22日-下午4:17:41
 * 
 */
@Component
public class RedisUtil {

	Logger log = LoggerFactory.getLogger(RedisUtil.class);
	
    @Autowired
    private JedisPool jedisPool;

    /**
     * 向Redis中存值，永久有效
     */
    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key, value);
        } catch (Exception e) {
            return "0";
        } finally {
            returnResource(jedisPool, jedis);
        }
    }

    /**
     * 根据传入Key获取指定Value
     */
    public String get(String key) {
        Jedis jedis = null;
        String value;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            return "0";
        } finally {
            returnResource(jedisPool, jedis);
        }
        return value;
    }

    /**
     * 校验Key值是否存在
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            return false;
        } finally {
            returnResource(jedisPool, jedis);
        }
    }

    /**
     * 
     * @param key
     * @return
     */
    public Long delete(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        } catch (Exception e) {
            return 0L;
        } finally {
            returnResource(jedisPool, jedis);
        }
    }
    
    /**
     * 取列表值
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> range(String key,long start,long end) {
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
        	log.error("redis range error={}", e.getMessage());
            return null;
        } finally {
            returnResource(jedisPool, jedis);
        }
    }   
    
    /**
     * 向列表添加元素
     * @param key
     * @param val
     * @return
     */
    public Long lpush(String key,String val) {
    	Jedis jedis= null;
    	try {
            jedis = jedisPool.getResource();
            return jedis.lpush(key, val);
		} 
    	catch (Exception e) {
        	log.error("redis lpush error={}", e.getMessage());
            return null;
        }
    	finally {
    		returnResource(jedisPool, jedis);
		}
    }
    
    /**
     * 
     * @param key
     * @param hash
     * @return
     */
    public String hmset(String key, Map<String, String> hash) {
    	Jedis jedis= null;
    	try {
            jedis = jedisPool.getResource();
            return jedis.hmset(key, hash);
		} 
    	catch (Exception e) {
        	log.error("redis lpush error={}", e.getMessage());
            return null;
        }
    	finally {
    		returnResource(jedisPool, jedis);
		}
	}
    
    /**
     * 
     * @param key
     * @param hash
     * @return
     */
    public List<String> hmget(String key, String fields) {
    	Jedis jedis= null;
    	try {
            jedis = jedisPool.getResource();
            return jedis.hmget(key, fields);
		} 
    	catch (Exception e) {
        	log.error("redis hmget error={}", e.getMessage());
            return null;
        }
    	finally {
    		returnResource(jedisPool, jedis);
		}
	}
    
    /**
     * 
     * @param key
     * @param hash
     * @return
     */
    public Map<String, String> hgetall(String key) {
    	Jedis jedis= null;
    	try {
            jedis = jedisPool.getResource();
            return jedis.hgetAll(key);
		} 
    	catch (Exception e) {
        	log.error("redis hmget error={}", e.getMessage());
            return null;
        }
    	finally {
    		returnResource(jedisPool, jedis);
		}
	}
    
    // 以上为常用方法，更多方法自行百度

    /**
     * 释放连接
     */
	private static void returnResource(JedisPool jedisPool, Jedis jedis) {
        if (jedis != null) {
            //jedisPool.returnResource(jedis);
        	jedis.close();
        }
    }
}
