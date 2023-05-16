package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.mypac.Member;

public class MainClass08 {
	public static void main(String[] args) {
		//수정할 회원의 정보
		int num = 1;
		String name = "주지";
		String addr = "부산";
		
		//아래의 update() 메소드를 이용해서 회원정보 수정
		Member m = new Member();
		m.num = num;
		m.name = name;
		m.addr = addr;
		
		MainClass08.update(m);
	}
	
	public static void update(Member mem) {
		//Member 객체에 담긴 정보를 이용해서 회원 정보를 수정
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
			String sql = "UPDATE member"
					+ " SET name = ?, addr = ?"
					+ " WHERE num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.name);	
			pstmt.setString(2, mem.addr);	
			pstmt.setInt(3, mem.num);

			pstmt.executeUpdate();
			System.out.println("회원 정보를 수정했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
