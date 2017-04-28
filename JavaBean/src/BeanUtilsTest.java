import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BeanUtilsTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException {
		Object bean = Class.forName("User").newInstance();
		BeanUtils.setProperty(bean, "username", "songxinjian");
		BeanUtils.setProperty(bean, "password", "sxj");
		
		System.out.println(bean);
		
		String username = BeanUtils.getProperty(bean, "username");
		System.out.println(username);
		
		Map<String,Object> map = new HashMap<>();
		map.put("username", "sxj");
		map.put("password", "pwd");
		
		BeanUtils.populate(bean, map);
		System.out.println(bean);
		
	}
}
