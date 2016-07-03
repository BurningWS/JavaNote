package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class TestInterface {
	public static void main(String[] args) {
		ApplicationContext con = new ClassPathXmlApplicationContext("Resources/springbean.xml"); //DI at this time

		System.out.println("1----");

		inter bean = (inter) con.getBean("a");
		System.out.println(bean.f());
		
		System.out.println(con.getBean("test.C"));  // use full name as his default id
	}
}

interface inter {
	String f();
}

class A implements inter{
	B b;
	
	private A() { 		 //spring use reflection to create a bean..
		System.out.println("A ini...");
	}
	
	private A(B bb) {
		System.out.println("A(B bb) ini...");
		this.b = bb;
	}

	@Override
	public String f() {
		return "A..."+b;
	}

	public void setB(B b) {
		this.b = b;
	}
}

class B {
	
	private B() {
		System.out.println("B ini...");
	}
	
	@Override
	public String toString() {
		return "B....";
	}
}

class C {
	private C() {
		System.out.println("C ini...");
	}
	
	static {
		System.out.println("C static block..");
	}

	public void start() {
		System.out.println("C start...");
	}
	public void stop() {
		System.out.println("C destroy...");
	}
	
}