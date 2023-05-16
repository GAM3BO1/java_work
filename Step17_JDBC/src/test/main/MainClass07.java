package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.mypac.Member;

public class MainClass07 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "한량";
		String addr = "보령시";

		//아래의 메소드를 호출해서 위의 회원 정보가 DB에 저장되도록 프로그래밍
		//위의 정보를 Member 객체에 담아서 insert() 메소드의 매개변수에 전달
		Member m = new Member();
		m.name = name;
		m.addr = addr;
		
		MainClass07.insert(m);
	}

	public static void insert(Member mem) {
		//mem에 담겨진 정보를 이용해서 회원 한명의 정보를 DB에 저장되도록 하기
		
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
			pstmt.setString(1, mem.name);	
			pstmt.setString(2, mem.addr);	

			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
