package resource;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("resource.xml");
		MyResource m =  (MyResource) con.getBean("r");
		m.testResource();
	}
}
