package test.main;

import test.mypac.Student;

public class MainClass01 {
	public static void main(String[] args) {
		//객체 생성하고 버리기~!
		new Student();
		//객체 생성하고 한번 사용하고 버리기~!
		new Student().study();
		
		Student s1 = new Student();
		s1.study();
		s1.study();
	}
}
 