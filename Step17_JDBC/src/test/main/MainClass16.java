package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass16 {
	public static void main(String[] args) {
		//모든 회원 정보 가져오기
		List<MemberDto> list = new MemberDao().getList();
		//가져와서 콘솔창에 출력
		for(MemberDto tmp: list) {
			System.out.println(tmp.getNum() + " | "
					+ tmp.getName() + " | "
					+ tmp.getAddr());
		}
	}
}
