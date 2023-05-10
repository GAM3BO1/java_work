package test.main;

public class MainClass07 {
	//static 메소드에서 사용하려면 static 필드로 만들어야 함
	public static int num = 999;
	//main 메소드는 static 메소드
	public static void main(String[] args) {
		//클래스명.필드명 형식으로 static 필드를 참조
		int result = MainClass07.num + 1;
		
		//main() 메소드와 num 필드는 둘 다 MainClass07 안에 속해 있으므로(같은 공간) 클래스명.은 생략 가능
		int result2 = num + 1;
		
		//static 없이 정의한 test() 메소드가 호출 가능한가?
//		test();	(x)
//		this.test(); (x)
		
		//static 으로 정의한 test() 메소드 호출
		MainClass07.test();	//정석적인 호출 방법
		test();	//동일 클래스 내이기 때문에 클래스명. 생략 가능
		
	}
	
	public static void test() {
		System.out.println("test() 메소드가 호출되었습니다.");
	}

}
