package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizMain2 {
	public static void main(String[] args) {
		//sample 데이터
		Map<String, String> dic = new HashMap<>();
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		
		/*
		 *  검색할 단어를 입력하세요: house
		 *  house 의 뜻은 집입니다.
		 *  
		 *  검색할 단어를 입력하세요: home
		 *  home 는 목록에 없습니다.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 단어를 입력하세요: ");
		String word = scan.nextLine();
		
		//입력받은 단어를 Map의 key 값으로 활용해서 value 값을 읽어오기
		String mean = dic.get(word);	//입력받은 단어를 key값으로 하는 value가 없으면 null이 리턴
		if(mean == null) {
			System.out.println(word + " 는 목록에 없습니다.");
		}else {
			System.out.println(word + " 의 뜻은 " + mean + "입니다.");
		}
	}
}
