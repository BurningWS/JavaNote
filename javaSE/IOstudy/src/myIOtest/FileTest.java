package myIOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		// testDir();
		// test1();
		// test2();
		test3();
	}

	public static void test3() {
		System.err.println("aaa");
		System.out.println("bbb");
	}

	public static void test2() {
		File f = new File("A");
		String[] s = f.list();
		for (String str : s) {
			System.out.print(str + "---");
		}
		File[] fs = f.listFiles();
		for (File fe : fs) {
			copy(fe);
			System.out.println(fe.toURI());
		}
	}

	static void copy(File f) {
		if (!f.isFile()) {
			return;
		}
		try {
			FileInputStream fis = new FileInputStream(f);
			String path = f.getParentFile().getAbsolutePath() + "\\";
			System.out.println(path);
			String name = f.getName();
			FileOutputStream fos = new FileOutputStream(path
					+ name.substring(0, name.lastIndexOf(".")) + "_copy"
					+ name.substring(name.lastIndexOf(".")), true);
			byte[] b = new byte[1024];
			int len = -1;
			while ((len = fis.read(b)) > -1) {
				fos.write(b, 0, len);
			}
			fos.write("\n这是副本".getBytes());
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void test1() {
		File f = new File("A/b/c");
		f.mkdirs();
		for (int i = 0; i < 5; i++) {
			f = new File("a", "f" + i + ".txt");
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testDir() {
		File f = new File("a/b/c");
		if (!f.exists()) {
			System.out.println("create a file or dir...");
			// f.createNewFile();
			f.mkdirs();
		}
		System.out.println(f.canExecute() + "--" + f.canRead() + "---"
				+ f.canWrite());
		f.deleteOnExit();

		f = new File("t");
		try {
			File.createTempFile("test", ".java", new File("d://"));
			System.out.println("ok...");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(f.getParent());
		System.out.println(f.getParentFile());
		System.out.println(f.getPath());
		System.out.println(f.getFreeSpace());

	}
}
