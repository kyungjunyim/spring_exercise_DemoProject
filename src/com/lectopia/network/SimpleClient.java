package com.lectopia.network;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.30.64", 5679);
			System.out.println("Ŭ���̾�Ʈ ������ �����Ǿ����ϴ�. ȣ��Ʈ : " + socket);
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject("�ȳ��ϼ��� �Ӱ����Դϴ�.");
			oos.flush();
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Object obj = ois.readObject();
			
			System.out.println("���� ������ : " + obj);
			
			socket.close();
			System.out.println("������ �ݾҽ��ϴ�.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
