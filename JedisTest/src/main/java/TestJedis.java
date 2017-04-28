import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class TestJedis {
	private Jedis jedis = JedisUtil.getJedis();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test(){
	}
}
