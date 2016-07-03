package myIOtest;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedErTest {

	public static void main(String[] args) throws InterruptedException {
		Receiver1 r = new Receiver1();
		Sender1 s = new Sender1();
		try {
			r.getPr().connect(s.getPw());
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Thread(r).start();
		Thread.sleep(3000);
		new Thread(s).start();
	}

}

class Receiver1 implements Runnable {

	private PipedReader pr = new PipedReader();
	private char[] buf = new char[1024];

	@Override
	public void run() {
		try {
			System.out.println(pr.ready());  
			int len = pr.read(buf); 			//这里会阻塞
			System.out.println(new String(buf, 0, len));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedReader getPr() {
		return pr;
	}
}

class Sender1 implements Runnable {
	
	private PipedWriter pw = new PipedWriter();
	
	@Override
	public void run() {
		try {
			pw.write("abcdefg你好陌生人");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedWriter getPw() {
		return pw;
	}

}