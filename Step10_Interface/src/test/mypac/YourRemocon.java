package test.mypac;

public class YourRemocon implements Remocon{

	@Override
	public void up() {
		System.out.println("볼륨을 올려용");
	}

	@Override
	public void down() {
		System.out.println("볼륨을 내려용");
	}
	
}
