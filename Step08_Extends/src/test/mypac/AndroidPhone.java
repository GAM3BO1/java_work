package test.mypac;

public class AndroidPhone extends HandPhone{
	//생성자
	public AndroidPhone() {
		System.out.println("AndroidPhone 생성자 호출");
	}
	
	//메소드
	public void doInternet() {
		System.out.println("인터넷 해용");
	}
	
	//메소드
	public void showPlatform() {
		System.out.println("안드로이드 운영체제입니다");
	}
	
	@Override	//해당 메소드가 재정의되었다고 단순히 표시하는 용도이며, 특별한 기능은 없음
	public void takePicture() {
//		super.takePicture();
		
		System.out.println("1000만 화소의 사진을 찍어용");
	}
}
