package test.mypac;

public class YourWeapon extends Weapon{
	
	//부모 클래스의 추상메소드를 반드시(강제로) 오버라이드 해야 함
	@Override
	public void attack() {
		//어디를 공격할지는 프로젝트 상황에 맞게 마음대로 공격하면 됨
		System.out.println("공중 공격!");
	}

}