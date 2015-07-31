package network;

import java.net.*;
public class ClientTest {
	public static void main(String[] args) {
		//클라이언트 연습 : 찾아갈 위치 분석
		//사용하는 클래스 : InetAddress, Socket
		
		InetAddress inet = null;
		try{//없는 컴퓨터는 오류가 남으로
			inet = InetAddress.getByName("www.naver.com"); //네이버의 주소를 가져와라
			//www.naver.com/202.179.177.21
			//포트는 80이 기본이기 때문에 생략 되었다.
			//IP주소를 -> naver.com 도메인
		
			System.out.println(inet);
		}catch(UnknownHostException e){
			System.out.println("there is no any site");
		}
		
		/*
		 *
		 * 네이버에 찾아가기 위해서는
		 * IP : 202.179.177.21, PORT: 80이라는 정보가 필요하다
		 * 이런 정보들이 www.naver.com에 들어 있다.
		 * 
		 * 친구에게 접속하고 싶으면
		 * 친구의 IP와 PORT를 알아야 한다.
		 * 친구에 물어봐서 안다.
		 * 
		 * (참고) 나의  IP 는 127.0.0.1 이다
		 *이것을 (localhost라고도 한다)
		 *cmd - ipconfig
		 *
		 *
		 *InetAddress 형태와 Port를 이용하여 접속한다
		 *(전화를 건다)
		 *
		 */
		
	}
}
