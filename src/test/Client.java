package test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {

	private InetAddress inet;
	private Socket socket;

	public Client() {
		try {
			inet = InetAddress.getByName("192.168.45.233");

			// inet정보를 바탕으로 연결 시도
			// socket = new Socket(inet, 포트 번호);
			socket = new Socket(inet, 20000);

			
			socket.close(); // 연결 종료
		} catch (Exception e) {
			System.out.println("접속 오류");
			System.exit(-1);
		}
	}
	
	public String text_input(){
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("입력 : ");
			String txt = scanner.next();
			sendMessage(txt);
	
		return null;
		
	}
	public void sendMessage(String txt) {
		System.out.println(txt);

		// 전송 : OutputStreamWriter, BufferedWriter, PrintWriter
		try {

			// 도구만들기
			// OutputStreamWriter osw = new OutputStreamWriter(대상);
			OutputStreamWriter osw = new OutputStreamWriter(
					socket.getOutputStream());
			// 전송할 대상 : 소켓에있는 보내는 부분 : socket.outputStream

			// 문장이기 때문에 분해하는 buffer가 필요하다
			BufferedWriter bw = new BufferedWriter(osw); // 통로

			PrintWriter pw = new PrintWriter(bw); // 버퍼

			// 전송
			// 전송은 pw를 이용한다
			pw.println(txt);

			// 분해해놓은 것을 날려보내는 flush
			pw.flush();// 전송

			// 폐기
			// 다했으면 종료
		} catch (Exception e) {
			System.err.println("전송 오류");
		}
	}

	public static void main(String[] args) {
		new Client();
	}
}
