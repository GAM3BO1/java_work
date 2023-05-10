package test.auto;

/*
 *  - 접근 지정자 접근범위
 *  public: 어디에서나 접근 가능
 *  protected: 동일한 package 혹은 상속관계에서 자식에서 접근 가능
 *  default: 동일한 package 안에서만 접근 가능 (접근지정자 생략 시 기본값은 default)
 *  private: 동일한 클래스 혹은 동일한 객체 안에서만 접근가능
 *  
 *  - 접근 지정자 붙이는 위치
 *  1. 클래스 선언 할 때 (import)
 *  2. 생성자 (new)
 *  3. 필드 (.)
 *  4. 메소드 (call)
 *  
 *  클래스는 default와 public 두가지의 접근지정자만 지정 가능
 *  접근 지정자를 생략한 것이 default 접근지정자
 */
public class Car {
	//필드
	protected Engine engine;
	
	//Engine 객체를 생성자의 인자로 전달받는 생성자
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	//메소드
	public void drive() {
		if(this.engine == null) {
			System.out.println("Engine 객체가 없어서 달릴 수 없어용");
			return;	//메소드 끝내기
		}
		System.out.println("부릉부릉");
	}
}
