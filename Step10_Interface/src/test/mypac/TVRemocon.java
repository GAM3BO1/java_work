package test.mypac;

public class TVRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("TV 채널을 올려용");
	}

	@Override
	public void down() {
		System.out.println("TV 채널을 내려용");
	}
	
	//내가 편하게 사용할 메소드 만들고 싶음
	public void reserve() {
		System.out.println("전원 off를 예약합니당");
	}
}
