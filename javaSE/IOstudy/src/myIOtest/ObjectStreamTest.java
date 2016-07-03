package myIOtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamTest {
	
	private static final String fname = "obj.txt";
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		write();
		read();
	}
	
	public static void write() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
		oos.writeDouble(3.14159);
		oos.writeUTF("我选你你造吗");
		oos.writeObject(new Mouse("mm", 1, true));   //对象序列化
		oos.close();
	}
	
	public static void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
		System.out.println(ois.readDouble());
		System.out.println(ois.readUTF());
		System.out.println(ois.readObject());   //反序列化
		ois.close();
	}
}

class Mouse implements Serializable { //必须实现这个接口
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private static int age;
	private transient boolean male;

	@Override
	public String toString() {
		return "Mouse [name=" + name + ", age=" + age + ", male=" + male + "]";
	}

	public Mouse(String name, int age, boolean male) {
		super();
		this.name = name;
		Mouse.age = age;
		this.male = male;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException { //在ObjectOutputStream中找,并注意private修饰
		oos.defaultWriteObject();
		oos.writeBoolean(male);
		System.out.println("write-----"+male);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		male = ois.readBoolean();
		System.out.println("read-----"+male);
	}
}