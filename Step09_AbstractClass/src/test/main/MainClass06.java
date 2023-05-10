package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass06 {
	public static void main(String[] args) {
		//아래의 useWeapon() 메소드를 호출하려면 Weapon type의 참조값이 필요
		useWeapon(new MyWeapon());
		
		Weapon w1 = new MyWeapon();
		useWeapon(w1);
		
		//MyWeapon에는 추가 메소드가 없기 때문에 객체 생성할 때만 필요하고 type 자체는 필요없음
		MyWeapon w2 = new MyWeapon();
		useWeapon(w2);
		
		//이름이 없는 익명의 (지역 내부) 클래스로, extends Weapon한 클래스
		//익명의 Local Inner Class를 이용해서 Weapon type의 참조값을 얻어내서 
		Weapon w3 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무나 공격!");
			}
		};
		//참조값을 전달하여 사용하기
		useWeapon(w3);
		
		//메소드를 호출할 때 바로 익명클래스를 이용해서 Weapon type의 참조값을 얻어내서 사용하기
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("모두 공격!");
			}
		});
	}
	
	//Weapon type의 참조값을 전달받아서 사용하는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
		w.attack();
	}
}
