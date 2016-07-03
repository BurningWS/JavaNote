package schema.advice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import schema.advice.biz.AspectBiz;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("/schema/advice/aspect.xml");
		System.out.println("------");
		
		AspectBiz ab = (AspectBiz) con.getBean("aspectBiz");
		ab.biz();
		
		System.out.println();
		ab.throwException();   // the exception is captured by around()
		
		System.out.println();
		ab.init("ws", 123);
		
		System.out.println();
		Fit fit = (Fit) ab;
		fit.filter();
	}
}
