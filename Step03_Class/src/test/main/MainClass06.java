package test.main;

import test.mypac.MyUtil;

public class MainClass06 {
	public static void main(String[] args) {
		// MyUtil 클래스의 send() 메소드 호출
		MyUtil.send();
		// MyUtil 클래스의 version 필드 참조
		String v = MyUtil.version;
		
		System.out.println("YO!");
		
		//1970년 1월 1일 자정으로부터 현재까지 경과시간을 mili second 단위로 얻어냄
		long time = System.currentTimeMillis();
		System.out.println(time);
	}
}
