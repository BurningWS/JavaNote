package pipedStream;

import java.io.IOException;
import java.io.PipedOutputStream;

class Send implements Runnable {
	// 实现Runnable接口
	private PipedOutputStream pos = null; // 管道输出流

	public Send() {
		this.pos = new PipedOutputStream();// 实例化输出流
	}

	public void run() {
		String str = "Hello World，世界你好!!!";
		try {
			this.pos.write(str.getBytes()); // 输出信息
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			this.pos.close(); // 关闭输出流
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PipedOutputStream getPos() { // 通过线程类得到输出流
		return pos;
	}
}