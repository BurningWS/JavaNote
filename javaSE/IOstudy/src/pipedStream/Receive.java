package pipedStream;

import java.io.IOException;
import java.io.PipedInputStream;

class Receive implements Runnable { // 实现Runnable接口
	private PipedInputStream pis = null;

	public Receive() {
		this.pis = new PipedInputStream(); // 实例化输入流
	}

	public void run() {
		byte b[] = new byte[1024];
		int len = 0;
		try {
			len = this.pis.read(b); // 接收数据
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.pis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("接收的内容为：" + new String(b, 0, len));
	}

	public PipedInputStream getPis() {
		return pis;
	}
}