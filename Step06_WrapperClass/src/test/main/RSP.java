package test.main;

import java.util.Random;
import java.util.Scanner;

public class RSP {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] S = {"가위", "바위", "보"};
		System.out.println("(가위:0), (바위:1), (보:2)");
		
		System.out.println("입력하세요: ");
		int user = scan.nextInt();
		
		Random ran = new Random();
		int com = ran.nextInt(3);
		
		System.out.println("나:" + S[user] + " vs " + "com:" + S[com]);
		if(user == com) {
			System.out.println("비겼습니다");
		}else if((user + 1) % 3 == com) {
			System.out.println("졌습니다");
		}else {
			System.out.println("이겼습니다");
		}
	}
}
