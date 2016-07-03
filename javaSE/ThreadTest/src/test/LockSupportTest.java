package test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
	
	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		t.f();
		Thread.sleep(2000);
		t.v();
	}
	
	static class Test {
		private Thread t;
		
		public void f() {
			t = new Thread(new Runnable() {
				public void run() {
					System.out.println("打住");
					LockSupport.park();
					System.out.println("走了。。。");
				}
			});
			t.start();
		}
		
		public void v() {
			new Thread(new Runnable() {
				public void run() {
					System.out.println("走你");
					LockSupport.unpark(t);
				}
			}).start();
		}
	}
}
