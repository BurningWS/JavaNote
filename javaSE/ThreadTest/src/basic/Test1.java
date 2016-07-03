package basic;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15.
 * 接着再由线程1打印16,17,18,19,20....以此类推, 直到打印到75. 程序的输出结果应该为:
 * 
 * @author ws
 * 
 */
class Printer {
	private int cnt = 1;

	private int state = 1;

	public synchronized void f1() {
		while (true) {
			while (state != 1) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (cnt > 75)
				break;
			print();
			state = 2;
			notifyAll();
		}
	}

	public synchronized void f2() {
		while (true) {
			while (state != 2) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (cnt > 75)
				break;
			print();
			state = 3;
			notifyAll();
		}
	}

	public synchronized void f3() {
		while (true) {

			while (state != 3) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (cnt > 75)
				break;
			print();
			state = 1;
			notifyAll();

		}

	}

	private void print() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + cnt++);
		}
	}
}

public class Test1 {
	public static void main(String[] args) {
		final Printer p = new Printer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				p.f1();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				p.f2();
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				p.f3();
			}
		}).start();
	}
}
