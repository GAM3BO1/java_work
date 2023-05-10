package test.main;

import java.util.Random;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 *  1. run 했을때
		 *  cherry, apple, banana, melon, 7
		 *  5개의 문자열 중에서 1개가 랜덤하게 출력
		 */
		String[] str = {"cherry", "apple", "banana", "melon", "7"};
		//랜덤한 숫자를 얻어내기 위한 객체
		Random ran = new Random();
		//0~4 사이의 랜덤한 숫자를 하나 얻어내서
		int ranNum = ran.nextInt(5);
		
		System.out.println(str[ranNum]);
		
		System.out.println("===========슬롯머신=============");
		String[] result = new String[3];
		int tmp;
		
		for(int i = 0; i < 3; i++) {
			tmp = ran.nextInt(5);
			result[i] = str[tmp];
			System.out.print(str[tmp] + " ");
		}
		System.out.println();
		System.out.println("=============================");
		if((result[0]==result[1])&&(result[1]==result[2])) {
			System.out.println("☆일치☆");
		}
	}
}
