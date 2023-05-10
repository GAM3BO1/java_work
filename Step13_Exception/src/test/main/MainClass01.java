package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		//숫자 형식의 문자열을 입력받는다 "10" "20" "10.1" 등
		String inputNum = scan.nextLine();
		
		try {
			//문자열로 입력받은 숫자을 실제 숫자로 바꾼다
			double num = Double.parseDouble(inputNum);
			//위의 코드에서 예외가 발생하면 아래의 코드 두 줄은 실행하지 않고 catch 문으로 감
			//입력한 숫자에 100을 더한다
			double result = num + 100;
			System.out.println("입력한 숫자 + 100: " + result);
		}catch(NumberFormatException e) {	//e에는 예외 객체 참조값이 전달
			/*
			 *  실행 스택에서 일어난 일을 콘솔창에 출력하기
			 *  (자세한 예외 정보를 예외 객체가 콘솔창에 출력하게 하기)
			 */
			e.printStackTrace();
		}
		
		System.out.println("무언가 중요한 마무리 작업을 하고 main 메소드가 종료됩니덩");
	}
}
