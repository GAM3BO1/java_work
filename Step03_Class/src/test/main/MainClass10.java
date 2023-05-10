package test.main;

import test.mypac.Rect;

/*
 *  test.mypac 패키지에 클래스를 하나 만들기
 *  
 *  - 사각형의 폭(width), 높이(height)를 필드에 저장
 *  - 필드에 저장된 폭과 높이를 이용해서 사각형의 넓이를 콘솔창에 출력하는 메소드
 *  - 필드와 메소드는 모두 non static
 *  - 클래스명, 필드명, 메소드명은 자유
 */
public class MainClass10 {
	public static void main(String[] args) {
		//클래스를 만들었다면 여기에 코드를 추가해서 테스트
		Rect r1 = new Rect();
		r1.width = 10;
		r1.height = 20;
		
		r1.printArea();
		
		Rect r2 = new Rect();
		r2.width = 11;
		r2.height = 14;
		
		r2.printArea();
	}
}
