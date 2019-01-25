<%@page import="sub1.USER"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//데이터베이스 정보
	final String HOST = "jdbc:mysql://192.168.0.126:3306/kjh";
	final String USER = "kjh";
	final String PASS = "1234";
	
	Connection conn = null;
	ArrayList<USER> list = new ArrayList<>();
	conn = DriverManager.getConnection(HOST, USER, PASS);
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("SELECT * FROM `USER`;");
	
	try{
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계 - 데이터베이스 접속
		
		// 3단계 - 쿼리실행 객체 생성
		
		// 4단계 - 쿼리실행
		// SELECT 경우 -> executeQuery() 실행
		// INSERT, UPDATE, DELETE 경우 -> executeUpdate() 실행
		
		// 5단계 - 결과셋 처리(SELECT 경우)
		
		while(rs.next()){
			// 자바빈 객체 생성
			USER user = new USER();
			
			// 자바빈 객체에 rs객체 한 행에 대한 정보설정
			user.setSeq(rs.getInt(1));
			user.setUid(rs.getString(2));
			user.setName(rs.getString(3));
			user.setHp(rs.getString(4));
			user.setAddr(rs.getString(5));
			user.setPos(rs.getString(6));
			user.setDep(rs.getInt(7));
			user.setRdate(rs.getString(8));
			
			// 완성된 자바빈 객체 리스트에 저장
			list.add(user);
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		// 6단계 - 데이터베이스 종료
		rs.close();
		stmt.close();
		conn.close();
		
	}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>14-3</title>
</head>
<body>
	<h3>직원목록</h3>
	<table border="1">
		<tr>
			<th>번호		</th>
			<th>아이디	</th>
			<th>이름		</th>
			<th>휴대폰	</th>
			<th>주소		</th>
			<th>직급		</th>
			<th>부서번호	</th>
			<th>등록일	</th>
		</tr>
		
		<%
			for(USER user : list){
		%>
		
		<tr>
			<td><%= user.getSeq() %>	</td>
			<td><%= user.getUid() %>	</td>
			<td><%= user.getName() %>	</td>
			<td><%= user.getHp() %>		</td>
			<td><%= user.getAddr() %>	</td>
			<td><%= user.getPos() %>	</td>
			<td><%= user.getDep() %>	</td>
			<td><%= user.getRdate().substring(2, 10) %></td>
			<td><a href="#">수정</a></td>
			<td><a href="#">삭제</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>