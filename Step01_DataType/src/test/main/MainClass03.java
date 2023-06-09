package test.main;
/*
 *  [Java 기본 데이터 type]
 *  
 *  2. 논리형(boolean)
 *  
 *  - true, false 두 가지 값 중 하나
 *  - true, false를 직접 쓰거나 비교연산 혹은 논리 연산의 결과로 얻어낼 수 있음
 *  - 참과 거짓을 나타내는 데이터 type
 */
public class MainClass03 {
	public static void main(String[] args) {
		//논리형 변수 선언과 동시에 값 대입하기
		boolean isRun = true;
		
		if(isRun) {
			System.out.println("달려용~");
		}
		
		//비교 연산의 결과로 얻어진 boolean 값 담기
		boolean isGreater = 10 > 1;
		//논리 연산의 결과로 얻어진 boolean 값 담기
		boolean result = true || false;
		
		//한번 선언한 변수는 다시 선언할 수 없음
		//boolean result = false;
		result = false;	//변수에 다른 값을 대입할 수 있음(동일한 type인 경우)
		//다른 type 값은 변수에 담을 수 없음
		//result = 10;
	}
}
