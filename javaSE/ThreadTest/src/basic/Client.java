package basic;

import java.util.Random;

public class Client {

	static Object block = new Object();
	static int store = 0;

	static class Producer implements Runnable {

		@Override
		public void run() {
			produce();
		}

		void produce() {
			int add = new Random().nextInt(10);
			synchronized (block) {
				while (store + add > 20) {
					try {
						block.wait();
					} catch (InterruptedException e) {
					}
				}
				store += add;
				System.out.println("<--" + add + " total:" + store);
				block.notifyAll();
			}
		}
	}

	static class Consumer implements Runnable {

		@Override
		public void run() {
			consume();
		}

		void consume() {
			int cost = new Random().nextInt(10);
			synchronized (block) {
				while (store - cost < 0) {
					try {
						block.wait();
					} catch (InterruptedException e) {
					}
				}
				store -= cost;
				System.out.println("-->" + cost + " total:" + store);
				block.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		for (;;) {
			new Thread(new Consumer()).start();
			new Thread(new Producer()).start();
		}
	}

}
