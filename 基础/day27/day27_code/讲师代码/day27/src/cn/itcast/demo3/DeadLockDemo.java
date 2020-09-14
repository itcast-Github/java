package cn.itcast.demo3;

public class DeadLockDemo {
	public static void main(String[] args) {
		DeadLock dead = new DeadLock();
		Thread t0 = new Thread(dead);
		Thread t1 = new Thread(dead);
		t0.start();
		t1.start();
	}
}
