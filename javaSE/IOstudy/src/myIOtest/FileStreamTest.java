package myIOtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
	public static void main(String[] args) {
		write();
		read();
	}

	public static void write() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("file.txt");
			fos.write("好久不见啊".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			fos = new FileOutputStream("file.txt", true);  //表示追加
			fos.write("\n是啊是啊".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void read() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("file.txt");
			System.out.println(fis.available());
			fis.skip(2); //俩字节一个汉字
			
			byte[] b = new byte[1024];
			int len = fis.read(b);
			System.out.println(new String(b, 0, len));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
