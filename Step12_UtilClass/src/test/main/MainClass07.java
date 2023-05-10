package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 *  세 명의 회원정보(번호, 이름, 주소)를 HashMap 객체에 각각 담아서
		 *  ArrayList 객체에 누적시키기
		 *  List<HashMap<String, Object>> type이 필요
		 *  (HashMap 객체 3개, ArrayList 객체 1개 생성)
		 *  
		 *  반복문 돌면서 ArrayList 객체에 누적된 회원정보를 콘솔창에 순서대로 출력
		 */
		List<Map<String, Object>> mems = new ArrayList<>();
		
		Map<String, Object> mem1 = new HashMap<>();
		mem1.put("num", 1);
		mem1.put("name", "홍길동");
		mem1.put("addr", "수원시");
		mems.add(mem1);
		
		Map<String, Object> mem2 = new HashMap<>();
		mem2.put("num", 2);
		mem2.put("name", "백호");
		mem2.put("addr", "화성시");
		mems.add(mem2);
		
		Map<String, Object> mem3 = new HashMap<>();
		mem3.put("num", 3);
		mem3.put("name", "호영");
		mem3.put("addr", "보령시");
		mems.add(mem3);
		
		for(int i = 0; i < mems.size(); i++) {
			int num = (int) mems.get(i).get("num");
			System.out.print("num: " + num);
			String name = (String) mems.get(i).get("name");
			System.out.print(", name: " + name);
			String addr = (String) mems.get(i).get("addr");
			System.out.println(", addr: " + addr);
		}
		
//		for(Map<String, Object> tmp: mems) {
//			int num = (int)tmp.get("num");
//			String name = (String)tmp.get("name");
//			String addr = (String)tmp.get("addr");
//			System.out.println("num:" + num + ", name:" + name + ", addr:" + addr);
//		}
	}
}
