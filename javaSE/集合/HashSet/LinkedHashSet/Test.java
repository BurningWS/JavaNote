import java.util.LinkedHashSet;

public class Test {
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();  //有序，不重复
		lhs.add("Hello");lhs.add("Java");lhs.add("Hello");lhs.add("World!");
		System.out.println(lhs);
	}
}
