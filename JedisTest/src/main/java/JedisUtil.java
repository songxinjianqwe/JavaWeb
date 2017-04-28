import redis.clients.jedis.Jedis;

public class JedisUtil {
	private static Jedis jedis = new Jedis("115.159.210.179",6379);
	static{
		jedis.auth("130119");
	}
	public static Jedis getJedis(){
		return jedis;
	}
	
}
