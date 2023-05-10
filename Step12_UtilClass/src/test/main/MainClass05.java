package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Member 객체를 담을 수 있는 ArrayList 객체를 생성해서 참조값을 members라는 지역변수에 담기
		List<Member> members = new ArrayList<>();
		//2. 3명의 회원정보를 Member 객체에 각각 담기 (Member 객체가 3개 생성되어야 함)
		Member m1 = new Member(1, "홍길동", "수원시");
		Member m2 = new Member(2, "백호", "화성시");
		//디폴트 생성자를 호출해서 Member 객체를 생성하면
		Member m3 = new Member();
		//필드를 직접 참조해서 값을 넣어주어야 한다
		m3.num = 3;
		m3.name = "호영";
		m3.addr = "보령시";
		
		//3. 위에서 생성된 Member 객체의 참조값을 members List 객체에 모두 담기
		members.add(m1);
		members.add(m2);
		members.add(m3);
		/*
		 *  4. members List 객체에 담긴 내용을 이용해서 회원 목록을 아래와 같은 형식으로 반복문 돌면서 출력하기
		 *  
		 *  번호: 1, 이름: 홍길동, 주소: 수원시
		 *  번호: 2, 이름: 백호, 주소: 화성시
		 *  .
		 *  .
		 */
		for(int i = 0; i < members.size(); i++) {
			System.out.println("번호: " + members.get(i).num
					+ ", 이름: " + members.get(i).name
					+ ", 주소: " + members.get(i).addr);
		}
		
		System.out.println("----------------------------");
		
		for(Member m : members) {
			System.out.println("번호: " + m.num
					+ ", 이름: " + m.name
					+ ", 주소: " + m.addr);
		}
		
		System.out.println("----------------------------");
		
		members.forEach(m -> {
			System.out.println("번호: " + m.num
					+ ", 이름: " + m.name
					+ ", 주소: " + m.addr);
		});
	}
}
