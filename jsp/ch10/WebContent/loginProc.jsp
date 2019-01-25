<%@page import="sub1.User"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginProc</title>
</head>
<body>
	<h3>로그인 처리</h3>
	<%
		request.setCharacterEncoding("UTF-8");
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		
		if(uid.equals("abcd") && pass.equals("1234")){
			
			User user = new User();
			user.setUid("abcd");
			user.setPass("1234");
			user.setName("홍길동");
			
			session.setAttribute("User", user);
			
			response.sendRedirect("./loginResult.jsp?result=success");
			
		}else{
			response.sendRedirect("./loginResult.jsp?result=fail");
		}
	%>
	
	
</body>
</html>