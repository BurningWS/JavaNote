package adapter;

public class Adapter1 implements Target {
	private Adaptee adaptee;

	public Adapter1(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	/**
	 * 源类Adaptee有方法sampleOperation1 因此适配器类直接委派即可
	 */
	public void sampleOperation1() {
		this.adaptee.sampleOperation1();
	}

	/**
	 * 源类Adaptee没有方法sampleOperation2 因此由适配器类需要补充此方法
	 */
	@Override
	public void sampleOperation2() {
		// 写相关的代码
	}
}