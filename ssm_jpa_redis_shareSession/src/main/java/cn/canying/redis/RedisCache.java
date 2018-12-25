package cn.canying.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
 
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
 
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
 
public class RedisCache implements Cache {
 
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * Jedis客户端
     */
/*系统在不使用session共享的时候希望将查询的数据存入Redis时可以通过本类进行操作*/
    @Autowired
    private Jedis redisClient = createClient();
 
    private String id;
 
    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("必须传入ID");
        }
        System.out.println("MybatisRedisCache:id=" + id);
        this.id = id;
    }
 
    @Override
    public void clear() {
        redisClient.flushDB();
    }
 
    @Override
    public String getId() {
        return this.id;
    }
 
    @Override
    public Object getObject(Object key) {
        byte[] ob = redisClient.get(SerializeUtil.serialize(key.toString()));
        if (ob == null) {
            return null;
        }
        Object value = SerializeUtil.unSerialize(ob);
        return value;
    }
 
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
 
    @Override
    public int getSize() {
        return Integer.valueOf(redisClient.dbSize().toString());
    }
 
    @Override
    public void putObject(Object key, Object value) {
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
    }
 
    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
    }
 
    protected static Jedis createClient() {
 
        try {
            @SuppressWarnings("resource")
            JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
            return pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("初始化连接池错误");
    }
 
}
