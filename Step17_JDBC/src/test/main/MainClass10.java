package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num = 1;
		String name = "백수";
		String addr = "독산동";
		
		//MemberDto 객체 생성
		MemberDto dto = new MemberDto();
		//수정할 회원의 정보 담기
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		//update() 메소드의 매개변수에 전달해서 회원정보 수정
		update(dto);
	}
	
	public static void update(MemberDto dto) {
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			String sql = "UPDATE member"
					+ " SET name = ?, addr = ?"
					+ " WHERE num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());	
			pstmt.setString(2, dto.getAddr());	
			pstmt.setInt(3, dto.getNum());

			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
