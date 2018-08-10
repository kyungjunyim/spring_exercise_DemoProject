package com.lectopia.network;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(5678);
			System.out.println("���� ������ �غ� �Ǿ����ϴ�. ��Ʈ : 5678");
			
			Socket clientSocket = ss.accept();
			
			InputStream is = clientSocket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			System.out.println(ois.readObject());
			
			Date serverDate = new Date(System.currentTimeMillis());
			
			OutputStream os = clientSocket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject(serverDate + " from server");
			oos.flush();
			System.out.println("���� ������ : " + serverDate + " from server");
			
			clientSocket.close();
			System.out.println("������ �ݾҽ��ϴ�.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
