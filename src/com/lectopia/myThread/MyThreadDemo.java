package com.lectopia.myThread;

public class MyThreadDemo {
	public static void main(String[] args) {
		System.out.println("=========== 메인 스레드 시작 ===========");
		
		MyThread myThread1 = new MyThread("첫번째 쓰레드");
		MyThread myThread2 = new MyThread("두번째 쓰레드");
		myThread1.start();
		myThread2.start();
		System.out.println("=========== 메인 스레드 종료 ===========");
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
