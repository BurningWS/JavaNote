package myIOtest;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class printStreamTest {
	public static void main(String[] args) {
//		test();
		test1();
	}
	
	public static void test() {
		try {
			PrintStream ps = new PrintStream("a.txt");
			ps.println("yes,就是你");
			ps.append("what the fuck...");
			ps.print(false);
			
			try {
				Thread.sleep(5000);   //已经写入，构造函数默认为fileOutputStream..没有实现flush
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(ps.checkError());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void test1() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("c.txt"));
			pw.append("sss");
			pw.write(64);    //输出的是@
			pw.println(64);    //输出的是"64"
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
