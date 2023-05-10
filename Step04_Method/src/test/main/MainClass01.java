package test.main;

import java.io.File;
import java.util.Scanner;

import test.mypac.Airplane;
import test.mypac.Test;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		
		//return type이 void인 메소드 호출
		t.walk();
		//return type이 int인 메소드 호출하고 리턴되는 값을 a라는 int type 지역변수에 담기
		int a = t.getNumber();
		//return type이 String인 메소드 호출하고 리턴되는 값을 b라는 String type 지역변수에 담기
		String b = t.getGreeting();
		//return type이 Airplane인 메소드 호출하고 리턴되는 값을 c라는 Airplane type 지역변수에 담기
		Airplane c = t.getPlane();
		c.fly();
		
		//위에서 생성한 객체의 setNum() 메소드를 호출
		t.setNum(11);
		//위에서 생성한 객체의 setName() 메소드를 호출
		t.setName("한량");
		//위에서 생성한 객체의 setPlane() 메소드를 호출
		t.setPlane(new Airplane());
		
		t.send();
		t.send(11);
		t.send("한량");
		t.send(new Airplane());
		
		System.out.println("main 메소드가 종료!");
	}
}
