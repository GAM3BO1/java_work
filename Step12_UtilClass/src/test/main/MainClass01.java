package test.main;

import java.util.ArrayList;

/*
 *  java에서 배열은 크기를 조절할 수 없는 고정 배열이다
 *  따라서 동적으로 item을 추가하고 삭제하는 작업을 하려면 일반 배열은 사용할 수 없다
 *  
 *  그래서 해당 작업을 하려면 ArrayList 객체를 사용하면 된다
 */
public class MainClass01 {
	public static void main(String[] args) {
		//String type을 저장할 수 있는 ArrayList 객체 생성해서 참조값을 names에 담기
		ArrayList<String> names = new ArrayList<>();
		
		//3개의 String type을 저장하기
		names.add("홍길동");
		names.add("백호");
		names.add("호영");
		//0번 방의 아이템을 불러와서 item이라는 변수에 담기
		String item = names.get(0);
		//1번 방의 아이템 삭제
		names.remove(1);
		//0번 방에 "에이콘" 넣기
		names.add(0, "에이콘");
		//저장된 아이템의 개수(size)를 size라는 지역변수에 담기
		int size = names.size();
		//저장된 모든 아이템 전체 삭제
		names.clear();
		
	}
}
