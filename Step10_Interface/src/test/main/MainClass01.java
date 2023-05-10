package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		//Remocon 인터페이스 type의 참조값 어떻게 얻어낼 수 있나
//		Remocon r1 = new Remocon();		//생성자가 없어서 안됨
		Remocon r1 = new MyRemocon();
		r1.up();
		r1.down();
	}
}
