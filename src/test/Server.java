//서버와 클라이언트의 차이
//거느냐 받느냐의 차이
package test;

import java.io.*;
import java.net.*;

public class Server {
	private ServerSocket server;
	private Socket socket;

	public Server() {
		try {
			server = new ServerSocket(20000); // 20000번 포트를 개방한다
			System.out.println("서버 준비 완료");

			// 접속 대기
			socket = server.accept(); // 연결이 들어오면 집어 넣겠다.

			System.out.println("접속자 정보 : " + socket);

			receiveMessage();

		} catch (IOException e) {// 개방이 되지 않으면
			System.out.println("포트가 이미 사용중입니다.");
			System.exit(-1); // 비정상 종료
		}
	}
	
	public void receiveMessage() {
		// 메세지를 읽기 위하여 InputStreamReader, BufferedReader이 필요하다
		try {
			InputStreamReader isr = new InputStreamReader(
					socket.getInputStream()); // 대상 - Socket에서의 받는 부분
			BufferedReader br = new BufferedReader(isr); // 통로명

			// br을 통해 한줄씩 읽는다
			while (true) {
				String txt = br.readLine();
				
				if(txt == null)	break;
				System.out.println(txt);
			}
		} catch (Exception e) {
			System.err.println("전송 오류");
		}
	}

	public static void main(String[] args) {
		new Server(); // Server클래스의 생성자 호출(객체 생성)
	}
}

// IP
// PORT
// LOCALPORT
