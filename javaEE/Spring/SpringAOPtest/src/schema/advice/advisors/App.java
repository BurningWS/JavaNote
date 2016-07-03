package schema.advice.advisors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import schema.advice.advisors.service.InvokeService;
import schema.advice.biz.AspectBiz;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("/schema/advice/advisors/advisors.xml");
		System.out.println("------");
		
		InvokeService is = (InvokeService) con.getBean("invokeService");
		is.invoke();
		
		System.out.println();
		is.invokeException();
	}
}
