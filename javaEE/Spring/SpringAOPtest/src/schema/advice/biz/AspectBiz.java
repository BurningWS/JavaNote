package schema.advice.biz;

public class AspectBiz {

	public void biz() {
		System.out.println("AspectBiz biz.");
	}
	
	public void throwException() {
		System.out.println("throw new RuntimeException()");
		throw new RuntimeException();
	}

	public void init(String bizName, int times) {
		System.out.println("AspectBiz init : " + bizName + "   " + times);
	}

}
