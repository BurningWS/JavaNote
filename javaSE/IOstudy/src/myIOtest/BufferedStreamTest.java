package myIOtest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedStreamTest {

	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bufferedinputstream.txt"));
			int t = -1;
			try {
				while (bis.available() >= 0) {
					System.out.print((char)(bis.read()));
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
