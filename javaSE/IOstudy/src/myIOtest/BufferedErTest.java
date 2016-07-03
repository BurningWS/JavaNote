package myIOtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedErTest {
	
	public static void main(String[] args) {
//		write();
		read();
	}
	
	public static void write() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("b.txt"));
			bw.write('a');
			bw.newLine();
			bw.append("bcde");
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("b.txt"));
			String s = br.readLine();
			System.out.println(s+"}}}");  //当文本太长，只会显示为空格
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
