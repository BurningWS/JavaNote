package myIOtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcessFileTest {

	private static final String FileName = "file.txt";

	public static void main(String[] args) {
		File f = new File(FileName);
		if (f.exists()) {
			f.delete();
		}
		write();
		append();
		read();
	}

	public static void write() {
		try {
			RandomAccessFile raf = new RandomAccessFile(FileName, "rw");
			System.out.println(raf.getFD());
			raf.write("干巴爹~~~~112233\n\r".getBytes());
			raf.writeChars("干巴爹~~~~112233\n");
			raf.writeBoolean(true);
			raf.writeFloat(123.567f);
			raf.writeInt(8910);
			raf.writeUTF("你说啥");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void append() {
		try {
			RandomAccessFile raf = new RandomAccessFile(FileName, "rw");
			long len = raf.length();
			raf.seek(len);
			raf.write("\r\n9999998".getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void read() {
		try {
			RandomAccessFile raf = new RandomAccessFile(FileName, "r");
			/*long pos = raf.getFilePointer();
			while (pos++ < raf.length()) {
				System.out.println(raf.read());
			}*/
			
			/*byte[] b = new byte[1024];
			int len = -1;
			while ((len = raf.read(b)) > 0) {
				System.out.println(new String(b));
			}*/
			
			String s = null;
			while ( (s = raf.readLine()) != null) {
				System.out.println(new String(s.getBytes(), "utf-8"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
		
}
