package aspectj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import aspectj.biz.MoocBiz;
import schema.advice.biz.AspectBiz;

public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("aspectj/aspectJ.xml");
		System.out.println("------");
		
		MoocBiz mb = (MoocBiz) con.getBean("moocBiz");
		mb.save("Hi~");
		
		System.out.println();
		mb.throwException();
	}
}
