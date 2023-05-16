package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Data Access Object 
 *  
 *  - DB에 insert, update, delete, select 작업을 대신해주는 객체를 생성할 클래스 설계하기
 */
public class MemberDao {
	//인자로 전달되는 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		//MemberDto 객체의 참조값을 담을 변수 미리 선언
		MemberDto dto = null;
		
		//필요한 객체를 담을 지역변수 미리 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select문)
			String sql = "SELECT name, addr"
					+ " FROM member"
					+ " WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			//select문이 미완성이라면 여기서 완성
			pstmt.setInt(1, num);
			//select문 수행하고 결과를 ResultSet으로 리턴
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출
			while (rs.next()) {
				//현재 커서가 존재하는 row에 있는 정보를 추출해서
				//MemberDto 객체에 회원 한 명의 정보를 담음
				dto = new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
			}
		}
		
		return dto;
	}
	
	//전체 회원의 정보를 리턴하는 메소드
	public List<MemberDto> getList(){
		//회원 정보를 누적할 객체 생성
		List<MemberDto> list = new ArrayList<>();
		
		//필요한 객체를 담을 지역변수 미리 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql문(select문)
			String sql = "SELECT num, name, addr"
					+ " FROM member"
					+ " ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			//select문이 미완성이라면 여기서 완성
			
			//select문 수행하고 결과를 ResultSet으로 리턴
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 row에 있는 정보를 추출
			while(rs.next()) {
				//현재 커서가 존재하는 row에 있는 정보를 추출해서 사용
				
				//row에 있는 회원정보를 MemberDto 객체에 담기
				MemberDto dto = new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				
				//List에 누적
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {}
		}
		//회원 정보가 누적된 List 객체의 참조값 리턴
		return list;
	}
	//회원 한 명의 정보를 저장하고 해당 작업의 성공 여부를 리턴해주는 메소드
	public boolean insert(MemberDto dto) {
		//필요한 객체를 담을 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row의 개수를 담을 변수
		int rowCount = 0;	//초기값을 0으로 부여
		try {
			//Connection 객체의 참조값 얻어괴
			conn = new DBConnect().getConn();
			//실행할 sql문
			String sql = "INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES(member_seq.NEXTVAL, ?, ?)";
			//sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//sql문이 ?가 존재하는 미완성이라면 여기서 완성
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			//insert or update or delete문을 실제 수행하고 변호된 row의 개수 리턴
			rowCount = pstmt.executeUpdate();	//수행하고 리턴되는 값을 변수에 담는다
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	//예외가 밸생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {}
		}

		//변화된 row의 개수가 0보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {		//그렇지 않으면 작업 실패
			return false;
		}
	}

	//회원 한 명의 정보를 수정하고 해당 작업의 성공여부를 리턴해주는 메소드
	public boolean update(MemberDto dto) {
		//필요한 객체를 담을 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row의 개수를 담을 변수
		int rowCount = 0;	//초기값을 0으로 부여
		try {
			//Connection 객체의 참조값 얻어괴
			conn = new DBConnect().getConn();
			//실행할 sql문
			String sql = "UPDATE member"
					+ " SET name = ?, addr = ?"
					+ " WHERE num = ?";
			//sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//sql문이 ?가 존재하는 미완성이라면 여기서 완성
			pstmt.setString(1, dto.getName());	
			pstmt.setString(2, dto.getAddr());	
			pstmt.setInt(3, dto.getNum());
			//insert or update or delete문을 실제 수행하고 변호된 row의 개수 리턴
			rowCount = pstmt.executeUpdate();	//수행하고 리턴되는 값을 변수에 담는다
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	//예외가 밸생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {}
		}

		//변화된 row의 개수가 0보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {		//그렇지 않으면 작업 실패
			return false;
		}

	}

	public boolean delete(int num) {
		//필요한 객체를 담을 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		//insert, update, delete 작업을 통해서 변화된(추가, 수정, 삭제) row의 개수를 담을 변수
		int rowCount = 0;	//초기값을 0으로 부여
		try {
			//Connection 객체의 참조값 얻어괴
			conn = new DBConnect().getConn();
			//실행할 sql문
			String sql = "DELETE FROM member"
					+ " WHERE num = ?";
			//sql문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//sql문이 ?가 존재하는 미완성이라면 여기서 완성
			pstmt.setInt(1, num);
			//insert or update or delete문을 실제 수행하고 변호된 row의 개수 리턴
			rowCount = pstmt.executeUpdate();	//수행하고 리턴되는 값을 변수에 담는다
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	//예외가 밸생을 하던 안하던 실행이 보장되는 블럭에서 마무리 작업
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {}
		}

		//변화된 row의 개수가 0보다 크면 작업 성공
		if(rowCount > 0) {
			return true;
		}else {		//그렇지 않으면 작업 실패
			return false;
		}
	}
	
}
