package beanannotation.jsr;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("beanannotation.xml");
		System.out.println("------");
		
		JsrService js = (JsrService) con.getBean("jsrService");
		js.save();
	}
}
