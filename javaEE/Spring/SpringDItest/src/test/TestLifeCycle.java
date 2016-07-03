package test;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("lifecycle.xml");
		System.out.println("----");
		con.getBean("c");
		System.out.println("...");

		con.close();
	}
}

class D implements InitializingBean, DisposableBean { // Spring container will execute the method automaticlly

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("D start...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("D destroy..");
	}
	
}