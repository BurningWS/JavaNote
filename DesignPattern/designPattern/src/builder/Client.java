package builder;

public class Client {
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder(); // 创建具体建造者对象的任务交给客户端,
													// 将导演者对象与具体建造者对象的耦合变成动态的
		Director director = new Director(builder);
		director.construct();

		Product product = builder.retrieveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}
}