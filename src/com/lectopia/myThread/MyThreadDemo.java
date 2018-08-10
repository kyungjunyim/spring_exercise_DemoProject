package com.lectopia.myThread;

public class MyThreadDemo {
	public static void main(String[] args) {
		System.out.println("=========== ���� ������ ���� ===========");
		
		MyThread myThread1 = new MyThread("ù��° ������");
		MyThread myThread2 = new MyThread("�ι�° ������");
		myThread1.start();
		myThread2.start();
		System.out.println("=========== ���� ������ ���� ===========");
	}
}

class MyThread extends Thread {
	String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(name + " : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
}
