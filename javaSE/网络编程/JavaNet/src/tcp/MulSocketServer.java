package tcp;

import java.io.*;
import java.net.*;

/**
 * 赂麓脱脙脕卢陆脱碌胫echo路镁脦帽脝梅 鹿娄胫脺拢潞陆芦驴脥禄搂露唇路垄唇脥碌胫胫脷脠脻路麓脌隆赂酶驴脥禄搂露唇
 */
public class MulSocketServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		OutputStream os = null;
		InputStream is = null;
		// 录脿脤媒露唇驴脷潞脜
		int port = 10000;
		try {
			// 陆篓脕垄脕卢陆脱
			serverSocket = new ServerSocket(port);
			System.out.println("路镁脦帽脝梅脪修脝么露炉拢潞");
			// 禄帽碌脙脕卢陆脱
			socket = serverSocket.accept();
			// 鲁玫脢录禄炉脕梅
			is = socket.getInputStream();
			os = socket.getOutputStream();
			byte[] b = new byte[1024];
			for (int i = 0; i < 3; i++) {
				int n = is.read(b);
				// 脢盲鲁枚
				System.out.println("驴脥禄搂露唇路垄唇脥胫脷脠脻脦陋拢潞" + new String(b, 0, n));
				// 睃貌驴脥禄搂露唇路垄唇脥路麓脌隆胫脷脠脻
				os.write(b, 0, n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 鹿脴卤脮脕梅潞脥脕卢陆脱
				os.close();
				is.close();
				socket.close();
				serverSocket.close();
			} catch (Exception e) {
			}
		}
	}
}