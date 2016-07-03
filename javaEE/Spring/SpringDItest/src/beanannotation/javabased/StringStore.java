package beanannotation.javabased;
public class StringStore implements Store<String> {
	
	public void init() {
		System.out.println("StringStore is init.");
	}
	
	public void destroy() {
		System.out.println("StringStore is destroy.");
	}
	
}
