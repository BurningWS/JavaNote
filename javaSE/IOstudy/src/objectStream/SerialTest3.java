package objectStream;

/**
 * 序列化的演示测试程序
 *
 * @author skywang
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerialTest3 {
	private static final String TMP_FILE = "serialtest3.txt";

	public static void main(String[] args) {
		// 将“对象”通过序列化保存
		testWrite();
		// 将序列化的“对象”读出来
		testRead();
	}

	/**
	 * 将Box对象通过序列化，保存到文件中
	 */
	private static void testWrite() {
		try {
			// 获取文件TMP_FILE对应的对象输出流。
			// ObjectOutputStream中，只能写入“基本数据”或“支持序列化的对象”
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(TMP_FILE));
			// 创建Box对象，Box实现了Serializable序列化接口
			Box2 box = new Box2("desk", 80, 48);
			// 将box对象写入到对象输出流out中，即相当于将对象保存到文件TMP_FILE中
			out.writeObject(box);
			// 打印“Box对象”
			System.out.println("testWrite box: " + box);

			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 从文件中读取出“序列化的Box对象”
	 */
	private static void testRead() {
		try {
			// 获取文件TMP_FILE对应的对象输入流。
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					TMP_FILE));
			// 从对象输入流中，读取先前保存的box对象。
			Box2 box = (Box2) in.readObject();
			// 打印“Box对象”
			System.out.println("testRead  box: " + box);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * Box2类“支持序列化”。因为Box实现了Serializable接口。
 * 
 * 实际上，一个类只需要实现Serializable即可实现序列化，而不需要实现任何函数。
 */
class Box2 implements Serializable {
	private static int width; // 静态成员变量
	private transient int height; // 瞬态成员变量
	private String name; // 普通...

	public Box2(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "[" + name + ": (" + width + ", " + height + ") ]";
	}
}

/**
 * 先说，为什么height=0。因为Box对象中height是int类型，而int类型的默认值是0。
 * 再说，为什么width=80。这是因为height是static类型
 * 而static类型就意味着所有的Box对象都共用一个height值；而在testWrite()
 * 中，我们已经将height初始化为80了。因此，我们通过序列化读取出来的Box对象的height值，也被就是80。
 */

