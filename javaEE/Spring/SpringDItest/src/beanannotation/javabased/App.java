package beanannotation.javabased;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("beanannotation.xml");
		System.out.println("------");
		
		StringStore s = (StringStore) con.getBean("stringStore");
		System.out.println(s.getClass().getName());
		
		System.out.println();
		con.getBean("myDriverManager");
		
		StoreConfig sc = (StoreConfig) con.getBean("storeConfig"); // configClass itself is also included..
		System.out.println(sc.getClass().getName());
	}
}
