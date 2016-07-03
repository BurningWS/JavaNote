package beanannotation.injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("beanannotation.xml");
		System.out.println("------");
		
		InjectionServiceImpl s = (InjectionServiceImpl) con.getBean("injectionServiceImpl");
		s.save("Hello!");
	}
}
