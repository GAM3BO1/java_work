package test.mypac;

public class Rect {
	//필드
	public int width;
	public int height;
	
	//메소드
	public void printArea() {
		//넓이 계산
		int area = this.width * this.height;
		//콘솔창에 넓이 출력
		System.out.println("사각형의 넓이:" + area);
	}
}
