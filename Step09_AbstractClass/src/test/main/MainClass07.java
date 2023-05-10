package test.main;

import test.mypac.Car;

public class MainClass07 {
	public static void main(String[] args) {
		//개발자가 코딩하는 위치
		
		//달리기는 하지만
		useCar(new Car());
		//조금 더 빨리 달리고 싶다
		//누군가 미리 만들어 놓은 Car 클래스의 drive() 메소드를 수정하는 것은 불가능
		
		useCar(new Car() {	//Car를 extends 한 익명 클래스
			@Override
			public void drive() {
				System.out.println("더 빨리 부릉부릉~");
			}
		});
	}
	
	//누군가 미리 만들어 놓은 메소드
	public static void useCar(Car c) {
		c.drive();
		c.drive();
	}
}
