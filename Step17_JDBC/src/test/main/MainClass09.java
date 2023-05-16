package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		String name = "에이콘";
		String addr = "강남역";
		
		//아래의 insert() 메소드를 활용해서 위의 회원정보가 DB에 저장
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		MainClass09.insert(dto);
	}
	
	public static void insert(MemberDto dto) {
		//인자로 전달된 MemberDto 객체에 담긴 내용을 이용해서 DB에 회원정보가 저장
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

		PreparedStatement pstmt = null;
		try {
			String sql = "INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());	
			pstmt.setString(2, dto.getAddr());	

			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
