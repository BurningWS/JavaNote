package autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("autowiring.xml");
		AutoWiringService bean = (AutoWiringService) con.getBean("service");
		bean.say("hello world~");
	}
}
