package myIOtest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamConverter {

	public static void main(String[] args) {
		write();
		read();
	}
	
	public static void write() {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("a.txt"),"utf-8");
			osw.write("生活如此精彩");
			System.out.println(osw.getEncoding());
			osw.close();  		//close必须要有，不然不会写进去
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read() {
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"));
			System.out.println(isr.getEncoding() + "|" + isr.ready());
			char[] buf = new char[1024];
			int len = isr.read(buf);
			System.out.println(new String(buf, 0, len));    //出现乱码
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
