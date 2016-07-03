package reflect3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflect0.Person");
		
		//Method[] methods = c.getMethods();  //銮峰彇镊繁镄勫寘鎷埗绫荤殑鍏叡鏂规硶
		Method[] methods = c.getDeclaredMethods();  //銮峰彇镊繁镄勬墍链夋柟娉?
		for (Method method : methods) {
			System.out.println(method);
		}
		
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		
		//銮峰彇鍗曚釜鏂规硶
		Method m1 = c.getMethod("show");
		m1.invoke(obj);
		
		Method m2 = c.getMethod("method", String.class);
		m2.invoke(obj, " Hello~");
		
		Method m3 = c.getMethod("getString", String.class, int.class);
		Object objString = m3.invoke(obj, "ws", 19);
		System.out.println(objString);
		
		Method m4 = c.getDeclaredMethod("function");
		m4.setAccessible(true);
		m4.invoke(obj);
	}
}
