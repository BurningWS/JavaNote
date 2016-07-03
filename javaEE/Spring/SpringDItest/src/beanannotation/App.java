package beanannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("beanannotation.xml");
		System.out.println("------");
		BeanAnnotation ba = (BeanAnnotation) con.getBean("ba");
		ba.say("hello!");
		ba.myHashCode();
		
		ba = (BeanAnnotation) con.getBean("ba");
		ba.myHashCode();  // hashcode will change
	}
}
