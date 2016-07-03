package reflect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("reflect0.Person");
//		Field[] fields = c.getFields();
		Field[] fields = c.getDeclaredFields();
		
		for (Field field : fields) {
			System.out.println(field);
		}
		
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		System.out.println(obj);
		
		Field addressField = c.getField("address");  //銮峰缑璇ュ瓧娈?
		addressField.set(obj, "beijing");
		System.out.println(obj);
		
		Field nameField = c.getDeclaredField("name");
		nameField.setAccessible(true);  //鍙栨秷璁块棶妫€镆?
		nameField.set(obj, "ws");
		System.out.println(obj);
	}
}
