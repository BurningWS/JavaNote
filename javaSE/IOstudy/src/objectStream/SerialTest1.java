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
  
public class SerialTest1 { 
    private static final String TMP_FILE = "serialtest1.txt";
  
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
            Box3 box = new Box3("desk", 80, 48);
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
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(TMP_FILE));
            // 从对象输入流中，读取先前保存的box对象。
            Box3 box = (Box3) in.readObject();
            // 打印“Box对象”
            System.out.println("testRead  box: " + box);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Box类“支持序列化”。因为Box实现了Serializable接口。
 *
 * 实际上，一个类只需要实现Serializable即可实现序列化，而不需要实现任何函数。
 */

class Box implements Serializable {
	private int width;
	private int height;
	private String name;

	public Box(String name, int width, int height) {
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
 * 源码说明：

(01) 程序的作用很简单，就是演示：先将Box对象，通过对象输出流保存到文件中；之后，再通过对象输入流，将文件中保存的Box对象读取出来。

(02) Box类说明。Box是我们自定义的演示类，它被用于序列化的读写。Box实现了Serialable接口，因此它支持序列化操作；即，Box支持通过ObjectOutputStream去写入到输出流中，并且支持通过ObjectInputStream从输入流中读取出来。

(03) testWrite()函数说明。testWrite()的作用就是，新建一个Box对象，然后将该Box对象写入到文件中。
       首先，新建文件TMP_FILE的文件输出流对象(即FileOutputStream对象)，再创建该文件输出流的对象输出流(即ObjectOutputStream对象)。
       a) 关于FileInputStream和FileOutputStream的内容，可以参考“java io系列07之 FileInputStream和FileOutputStream”。
       b) 关于ObjectInputStream和ObjectOutputStream的的更多知识，可以参考“java io系列05之 ObjectInputStream 和 ObjectOutputStream”
       然后，新建Box对象。
       最后，通过out.writeObject(box) 将box写入到对象输出流中。实际上，相当于将box写入到文件TMP_FILE中。

(04) testRead()函数说明。testRead()的作用就是，从文件中读出Box对象。
       首先，新建文件TMP_FILE的文件输入流对象(即FileInputStream对象)，再创建该文件输入流的对象输入流(即ObjectInputStream对象)。
       然后，通过in.readObject() 从对象输入流中读取出Box对象。实际上，相当于从文件TMP_FILE中读取Box对象。

通过上面的示例，我们知道：我们可以自定义类，让它支持序列化(即实现Serializable接口)，从而能支持对象的保存/恢复。
若要支持序列化，除了“自定义实现Serializable接口的类”之外；java的“基本类型”和“java自带的实现了Serializable接口的类”，都支持序列化。我们通过下面的示例去查看一下。
 */

