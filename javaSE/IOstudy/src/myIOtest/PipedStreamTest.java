package myIOtest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Arrays;

public class PipedStreamTest {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Sender s = new Sender();
		Receiver r = new Receiver();
		s.getPos().connect(r.getPis());
		new Thread(r).start();
		Thread.sleep(3000); // 等一会，再发
		new Thread(s).start();
	}
}

class Sender implements Runnable {

	public Sender() {
		super();
		this.pos = new PipedOutputStream();
	}

	private PipedOutputStream pos;

	public void run() {
		try {
			String s = "你好啊，我喜欢你";
			pos.write(s.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public PipedOutputStream getPos() {
		return pos;
	}

}

class Receiver implements Runnable {

	private PipedInputStream pis;

	public Receiver() {
		super();
		this.pis = new PipedInputStream();
	}

	public void run() {
		byte[] b = new byte[1024];
		try {
			System.out.println("进入堵塞");
			int len = pis.read(b);
			System.out.println(new String(b, 0, len));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public PipedInputStream getPis() {
		return pis;
	}

}