package test.main;

import test.mypac.AndroidPhone;
import test.mypac.HandPhone;

public class MainClass06 {
	public static void main(String[] args) {
		//일반 핸드폰(인터넷 안됨)
		HandPhone p1 = new HandPhone();
		
		//AndroidPhone ?
		AndroidPhone p2 = (AndroidPhone) p1;	//ClassCastException 발생! (Why.. 원래 객체가 HandPhone이라서)
		
		p2.doInternet();
	}
}
