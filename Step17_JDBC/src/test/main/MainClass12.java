package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "이매";
		String addr = "대전";
		
		//추가할 회원의 정보를 MemberDto 객체에 담기
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//DB에 저장
		new MemberDao().insert(dto);
	}
}
