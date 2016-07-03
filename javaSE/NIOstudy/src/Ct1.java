import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Ct1 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("D:/zhihu/cook.txt");
			
			FileChannel ch = fis.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(55);
			System.out.println(ch.size());
			
			int len;
			while ((len = ch.read(buf)) != -1) {
				System.out.println("read:" + len + "bytes");
				buf.flip();

				while (buf.hasRemaining()) {
					char c = (char) buf.get();
					System.out.print(c);
				}
				buf.clear();
				System.out.println();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
