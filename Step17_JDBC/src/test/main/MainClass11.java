package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		//삭제할 회원의 번호
		int num = 3;
		
		delete(num);
	}
	
	public static void delete(int num) {
		//인자로 전달된 num에 해당하는 회원정보를 삭제
		//DBConnect 클래스 활용
		
		Connection conn = null;
		conn = new DBConnect().getConn();
		
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM member"
					+ " WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			//sql문 실행하기
			pstmt.executeUpdate();
			System.out.println("회원 정보를 삭제했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
