package schema.api;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("/schema/api/api.xml");
		System.out.println("------");
		
		BizLogic bl = (BizLogic) con.getBean("bizLogicImpl");
		bl.save();
	}
}
