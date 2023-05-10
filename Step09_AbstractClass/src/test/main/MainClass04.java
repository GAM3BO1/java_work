package test.main;

public class MainClass04 {
	//static 메소드 안에서 사용하려면 static 예약어 필요
	public static class Yo{
		public void say() {
			System.out.println("Yo!");
		}
	}
	
	//static 메소드
	public static void main(String[] args) {
		Yo y = new Yo();
		y.say();
		
		/*
		 * 메소드 안에도 클래스를 정의할 수 있다
		 * 메소드 안에 정의한 클래스를 지역 내부 클래스라고 함 (Local Inner Class)
		 * 메소드 내부에서만 사용할 수 있다
		 */
		class Cat{
			public void say() {
				System.out.println("먘!");
			}
		}
		
		Cat c = new Cat();
		c.say();
		
	}
}
