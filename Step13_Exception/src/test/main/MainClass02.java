package test.main;

import java.util.Scanner;

public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나눌 수 입력: ");
		String inputNum1 = scan.nextLine();
		System.out.print("나눠지는 수 입력: ");
		String inputNum2 = scan.nextLine();
		
		try {
			int num1 = Integer.parseInt(inputNum1);
			int num2 = Integer.parseInt(inputNum2);
			
			int result = num2 / num1;	//몫
			int result2 = num2 % num1;	//나머지
			System.out.println(num2 + "를 " + num1 + "으로 나눈 몫: " + result);
			System.out.println(num2 + "를 " + num1 + "으로 나눈 나머지: " + result2);
		}catch(NumberFormatException nfe){
			System.out.println("숫자 형식으로 입력해주세용");
		}catch(ArithmeticException ae) {
			System.out.println("어떤 수를 0으로 나눌 수 없어용");
		}
		
		System.out.println("main 메소드 정상 종료");
	}
}
