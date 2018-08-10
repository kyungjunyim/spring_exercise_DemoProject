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
			System.out.println("클라이언트 소켓이 생성되었습니다. 호스트 : " + socket);
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			oos.writeObject("안녕하세요 임경준입니다.");
			oos.flush();
			
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			Object obj = ois.readObject();
			
			System.out.println("받은 데이터 : " + obj);
			
			socket.close();
			System.out.println("소켓을 닫았습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
