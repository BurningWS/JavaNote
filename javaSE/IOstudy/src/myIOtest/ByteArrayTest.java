package myIOtest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayTest {
	
	// 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
	private static final byte[] ArrayLetters = { 97, 98, 99, 100, 101, 102,
			103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115,
			116, 117, 118, 119, 120, 121, 122 };

	public static void test1() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.close(); // 方法为空，同bais
		baos.write(ArrayLetters, 1, 5);  //写入内置缓存 protected byte buf[];   
		baos.write(128);  //会取反-128
		int n = baos.size(); 
		System.out.println(n);

		byte[] b = baos.toByteArray();
		System.out.println(Arrays.toString(b));
		ByteArrayInputStream bais = new ByteArrayInputStream(b);  //构造函数时放入内置缓存 protected byte buf[];
		System.out.println("你问我兹磁不兹磁:"+bais.markSupported());
		
		for (int i = bais.available(); i >= 0; i--) {
			if (i == 4) {
				bais.mark(i);  //mark默认为0，这里传的值没意义，只是一个标记
				bais.skip(1);  
			}
			System.out.println(bais.available()+" "+bais.read());
		}
		
		bais.reset();
		byte[] c = new byte[10];
		bais.read(c);  //相当于 read(b, 0, b.length);
		System.out.println(Arrays.toString(c));

	}

	public static void main(String[] args) throws IOException {
		System.out.println(Arrays.toString(ArrayLetters));
		test1();
	}
}
