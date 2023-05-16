package test.dto;
/*
 *  Data Transfer Object
 *  
 *  - 여러개의 정보를 하나의 객체에 담기 위해 설계된 클래스
 *  - 필드의 접근 지정자는 모두 private
 *  - 접근 메소드 setter, getter 메소드가 있어야 한다
 *  - 디폴트(기본) 생성자가 있어야 한다
 *  - 인자로 필드의 모든 값을 전달받는 생성자도 있어야 한다(있으면 좋은 option)
 *  
 */
public class MemberDto {
	//접근 지정자가 private인 필드
	private int num;
	private String name;
	private String addr;

	//디폴트(기본) 생성자
	public MemberDto() {}
	
	//마우스 우클릭 -> source -> generate 메뉴에서 constructor와 getter, setter 메소드 생성 가능
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}