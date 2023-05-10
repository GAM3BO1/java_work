package test.main;

import test.mypac.Member;

public class MainClass08 {
	public static void main(String[] args) {
		//설계한 Member 클래스로 객체를 생성해서 참조값을 mem1이라는 지역변수에 담기
		Member mem1 = new Member();
		
		//mem1에 저장되어 있는 참조값을 이용해서 회원의 번호 1을 저장
		mem1.num = 1;
		//mem1에 저장되어 있는 참조값을 이용해서 회원의 이름을 저장
		mem1.name = "홍길동";
		//mem1에 저장되어 있는 참조값을 이용해서 회원의 주소를 저장
		mem1.addr = "수원시";
		//mem1에 저장되어 있는 참조값을 이용해서 showInfo() 메소드 호출해보기
		mem1.showInfo();
	}
}
