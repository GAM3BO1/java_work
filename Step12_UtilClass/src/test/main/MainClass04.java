package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type을 저장할 수 있는 ArrayList 객체를 생성해서 참조값을 List 인터페이스 type 지역변수 cars에 담기
		List<Car> cars = new ArrayList<>();
		
		//2. Car 객체(3개)를 생성해서 List 객체에 저장하기
		cars.add(new Car("SM3"));
		cars.add(new Car("SM5"));
		cars.add(new Car("SM7"));
		
		//3. 일반 for문을 이용해서 List 객체에 저장된 모든 Car 객체의 drive() 메소드를 순서대로 호출
		for(int i = 0; i < cars.size(); i++) {
			cars.get(i).drive();
		}
		System.out.println("-----------------------");
		//4. 확장 for문을 이용해서 List 객체에 저장된 모든 Car 객체의 drive() 메소드를 순서대로 호출
		for(Car c : cars) {
			c.drive();
		}
		System.out.println("-----------------------");
		//5. Consumer 인터페이스를 활용해서 List 객체에 저장된 모든 Car 객체의 drive() 메소드를 순서대로 호출
		cars.forEach(t -> t.drive());	//t에는 car의 참조값이 하나씩 전달
	}
}
