package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		//새로 추가할 회원정보
		String name = "익명";
		String addr = "출신불명";
		
		//추가할 회원의 이름과 주소를 dto 객체에 담기
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//MemberDao 객체를 이용해서 DB에 회원 정보를 저장하고 
		//저장이 성공되었다면 "저장했습니다"를 콘솔창에 출력	
		MemberDao dao = new MemberDao();
		
		boolean isSuccess = dao.insert(dto);
		if(isSuccess) {
			System.out.println("저장했습니다");
		}
	}
}
