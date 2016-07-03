package nio;
// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile {
	static public void main(String args[]) throws Exception {
		System.err.println("Usage: java CopyFile infile outfile");

		String infile = "D:/zhihu/cook.txt";
		String outfile = "D:/cc.txt";

		FileInputStream fin = new FileInputStream(infile);
		FileOutputStream fout = new FileOutputStream(outfile);

		FileChannel fcin = fin.getChannel();
		FileChannel fcout = fout.getChannel();

		ByteBuffer buffer = ByteBuffer.allocate(1024);

		while (true) {
			buffer.clear();

			int r = fcin.read(buffer);
			System.out.println("READ:" + r);
			if (r == -1) {
				break;
			}

			buffer.flip();

			fcout.write(buffer);
		}
	}
}
