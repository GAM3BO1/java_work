package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass14 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num = 1;
		String name = "홍길동";
		String addr = "시흥시";
		
		//수정할 회원의 정보를 MemberDto 객체에 담기
//		MemberDto dto = new MemberDto();
//		dto.setNum(num);
//		dto.setName(name);
//		dto.setAddr(addr);
		
		//생성자의 인자로 회원정보를 전달해서 객체를 생성
		MemberDto dto = new MemberDto(num, name, addr);
		
		//MemberDao 객체를 생성해서 update() 메소드를 이용해서 수정하고 성공여부 리턴 받기
		MemberDao dao = new MemberDao();
		boolean isSuccess = dao.update(dto);
		if(isSuccess) {
			System.out.println("수정했습니다");
		}
	}
}
