package beanannotation.multibean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("Resources/beanannotation.xml");
		System.out.println("------");
		
		BeanInvoker bi = (BeanInvoker) con.getBean("beanInvoker");
		bi.say();
	}
}
