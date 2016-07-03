package myIOtest;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayTest {
	private static final char[] ArrayLetters = "abcdefghijklmnopqrstuvwxyz"
			.toCharArray();

	public static void main(String[] args) {
		read();
		write();
	}

	public static void read() {
		CharArrayReader car = new CharArrayReader(ArrayLetters);
		try {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(car.read());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			car.mark(0);
			while (car.ready()) {
				System.out.print((char) car.read());
			}
			car.reset();
			car.skip(5);
			System.out.println("\n"+car.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write() {
		CharArrayWriter caw = new CharArrayWriter();
		caw.append("=+-").write(ArrayLetters, 1, 5);
		System.out.println(caw.size()+" | "+caw);
		
		CharArrayWriter caw1 = new CharArrayWriter();
		try {
			caw.writeTo(caw1);
			System.out.println(caw1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
