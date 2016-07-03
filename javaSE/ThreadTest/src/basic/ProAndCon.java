package basic;

import java.util.Random;

class Ware {
	private int capacity;
	private int size;

	public Ware() {
		size = 10;
		capacity = 20;
	}

	public synchronized void produce(int val) {
		while (size + val > capacity) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		size += val;
		System.out.println("Ware <-- "+val+", current:"+size);
		notifyAll();
	}
	
	public synchronized void consume(int val) {
		while (size - val < 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		size -= val;
		System.out.println("Ware --> "+val+", current:"+size);
		notifyAll();
	}
}

public class ProAndCon {
	
	public static void main(String[] args) {
		final Ware w = new Ware();
		
		new Thread(new Runnable() {   // producer
			public void run() {
				while (true) {
					w.produce(new Random().nextInt(10)+1);
				}
			}
		}).start();
		
		new Thread(new Runnable() {   // consumer
			public void run() {
				while (true) {
					w.consume(new Random().nextInt(10)+1);
				}
			}
		}).start();
		
	}
}
