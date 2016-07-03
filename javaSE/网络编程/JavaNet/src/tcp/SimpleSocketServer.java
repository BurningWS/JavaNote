package tcp;

import java.io.*;
import java.net.*;

import javax.jws.soap.SOAPBinding;

/**
 * echo服务器 功能：将客户端发送的内容反馈给客户端
 */
public class SimpleSocketServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;

		// 监听端口号
		int port = 10000;
		try {
			// 建立连接
			serverSocket = new ServerSocket(port);
			// 获得连接
			socket = serverSocket.accept();
			System.out.println("remotePort:"+socket.getPort()+" connected!!!");
			// 接收客户端发送内容
			is = socket.getInputStream(); // socket.getChannel(); //NIO!!!!

			byte[] b = new byte[1024];
			int n = is.read(b);
			// 输出
			System.out.println("客户端发送内容为：" + new String(b, 0, n));
			// 向客户端发送反馈内容
			os = socket.getOutputStream();
			os.write(b, 0, n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭流和连接
				os.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (Exception e) {
			}
		}
	}
}