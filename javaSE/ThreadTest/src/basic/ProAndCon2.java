package basic;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Home {
	private int capacity=20;
	private int size=10;
	Lock l = new ReentrantLock();
	Condition full = l.newCondition();
	Condition empty = l.newCondition();
	
	public void consume(int val) {
		try {
			l.lock();
			while (size+val > 20) {
				full.await();
			}
			size += val;
			System.out.printf("Home <-- %-2d Total:%-2d\n",val,size);
			empty.signalAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();
		}
	}
	
	public void produce(int val) {
		try {
			l.lock();
			while (size-val < 0) {
				empty.await();
			}
			size -= val;
			System.out.printf("Home --> %-2d Total:%-2d\n",val,size);
			full.signalAll();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();
		}
	}
	
}

public class ProAndCon2 {
	
	
	public static void main(String[] args) {
		final Home h = new Home();
		final Random r = new Random();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					h.consume(r.nextInt(10)+1);
				}
			}
		}).start();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					h.produce(r.nextInt(10)+1);
				}
			}
		}).start();
	}

}
