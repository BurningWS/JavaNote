package basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Output {
	private static final int _CNT = 75;
	private int cnt = 1;
	private int state = 1;
	private Lock l = new ReentrantLock();
	Condition c1 = l.newCondition();
	Condition c2 = l.newCondition();
	Condition c3 = l.newCondition();

	public void f1() {

		while (true) {
			try {
				l.lock();
				while (state != 1) {
					try {
						c1.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (check())
					break;
				Thread t = Thread.currentThread();
				for (int i = 0; i < 5; i++) {
					System.out.printf("%10s : %d\n", t.getName(), cnt++);
				}
				state = 2;
				c2.signal();
			} finally {
				l.unlock();
			}
		}
	}

	public void f2() {
		while (true) {
			try {
				l.lock();
				while (state != 2) {
					try {
						c2.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (check())
					break;
				Thread t = Thread.currentThread();
				for (int i = 0; i < 5; i++) {
					System.out.printf("%10s : %d\n", t.getName(), cnt++);
				}
				state = 3;
				c3.signal();
			} finally {
				l.unlock();
			}

		}
	}

	public void f3() {
		while (true) {
			try {
				l.lock();
				while (state != 3) {
					try {
						c3.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (check())
					break;
				Thread t = Thread.currentThread();
				for (int i = 0; i < 5; i++) {
					System.out.printf("%10s : %d\n", t.getName(), cnt++);
				}
				state = 1;
				c1.signal();
			} finally {
				l.unlock();
			}

		}
	}

	private boolean check() {
		return cnt > _CNT;
	}
}

public class Test2 {

	public static void main(String[] args) {
		final Output out = new Output();
		new Thread(new Runnable() {
			public void run() {
				out.f1();
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				out.f2();
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				out.f3();
			}
		}).start();
	}

}
