package network;

import java.io.IOException;
import java.net.*;

public class ServeTest {
	public static void main(String[] args) {
		// 서버 역할 연습 : 연결을 기다린다.
		// 사용하는 클래스 : ServerSocket, Socket
		ServerSocket server = null;

		for (int i = 0; i <= 65535; i++) {
			try { // 예외처리, 만약 전화기 개통때 번호가 겹치면 안된다.
					// 0~65535까지의 포트 중에 한개를 개방하낟

				server = new ServerSocket(i);
				server.close();
			} catch (IOException e) { // 만약에 사용 중이면
				System.out.println(i + "번은 사용 중이다.");
			}
		}
		//가급적 0 ~ 1023번 포트피해야 한다.
		//돈내고 사는 포트(well ~ known port)이다.
		
		
		//우리는 20000번 포트를 이용하기로 정한다.
		
	}
}
