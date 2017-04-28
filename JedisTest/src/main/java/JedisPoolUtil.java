import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	private static JedisPool instance;

	private JedisPoolUtil() {
	}

	public static JedisPool getInstance() {
		
		if (instance == null) {
			synchronized (JedisPoolUtil.class) {
				if (instance == null) {
					ResourceBundle bundle = ResourceBundle.getBundle("redis");
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")));
					config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
					config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWait")));
					config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
					config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
					instance = new JedisPool(config, bundle.getString("redis.ip"),
						    Integer.valueOf(bundle.getString("redis.port")));
				}
			}
		}
		return instance;
	}
	@SuppressWarnings("deprecation")
	public static void release(JedisPool pool, Jedis jedis){
		if(jedis != null){
			pool.returnResource(jedis);
		}
	}
}
