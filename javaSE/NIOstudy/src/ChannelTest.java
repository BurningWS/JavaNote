import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {
	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("D:/zhihu/cook.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		
		ByteBuffer buf = ByteBuffer.allocate(48);

		// The number of bytes read, possibly zero, or -1 if the channel has
		// reached end-of-stream
		int bytesRead = inChannel.read(buf);

		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			//The limit is set to the current position and then the position is set to zero.
			buf.flip();
			
			while (buf.hasRemaining()) {
				//Reads the byte at this buffer's current position, and then increments the position
				System.out.print((char) buf.get());
			}
			
			System.out.println();
			//The position is set to zero, the limit is set to the capacity
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
