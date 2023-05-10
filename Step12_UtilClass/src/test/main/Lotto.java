package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		//로또 구입 개수 받기
		System.out.print("로또를 몇 개 구입하시겠어요: ");
		int count = scan.nextInt();
		
		//원하는 로또 개수 만큼 시행
		for(int i = 0; i < count; i++) {
			//로또 숫자 목록
			List<Integer> lotto = new ArrayList<>();
			
			//각각의 로또 숫자 랜덤 생성 
			for(int j = 0; j < 6; j++) {
				//로또 숫자는 1 ~ 45 중 하나
				int lottoNum = ran.nextInt(44)+1;
				lotto.add(lottoNum);
				
				//로또 숫자 중복 제거
				if(j > 0) {
					for(int k = 0; k < j; k++) {
						if(lotto.get(j) == lotto.get(k)) {
							lotto.remove(j);
							j--;
						}
					}
				}
			}
			
			//로또 오름차순 정렬
			for(int n = 0; n < lotto.size()-1; n++) {
				for(int m = n+1; m < lotto.size(); m++) {
					if(lotto.get(n) > lotto.get(m)) {
						int tmp = lotto.get(n);
						lotto.set(n, lotto.get(m));
						lotto.set(m, tmp);
					}
				}
			}
			
			//로또 출력
			for(int l = 0; l < lotto.size(); l++) {
				System.out.print(lotto.get(l));
				if(l != lotto.size()-1) {
					System.out.print(", ");
				}
			}
			
			System.out.println("");
		}
	}
}
