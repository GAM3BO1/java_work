package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;
import test.mypac.TVRemocon;
import test.mypac.YourRemocon;

public class MainClass02 {
	public static void main(String[] args) {
		//다형성 확인
		MyRemocon r1 = new MyRemocon();
		Remocon r2 = r1;
		Object r3 = r1;
		
		//직접 클래스를 test.mypac 패키지에 파일로 만들어서 useRemocon() 메소드를 호출하기
//		Remocon r4 = new YourRemocon();
//		useRemocon(r4);
		
		TVRemocon r5 = new TVRemocon();
		useRemocon(r5);
		//나만의 기능 호출해보기
		r5.reserve();
		
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
		//만일 여기서 reverse() 메소드를 활용하고 싶다면
//		TVRemocon r2 = (TVRemocon) r;	//r의 타입이 TVRemocon인 경우만 사용 가능
//		r2.reserve();
	}
}
