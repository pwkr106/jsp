package cf.kjh.service.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cf.kjh.config.DBConfig;
import cf.kjh.config.SQL;
import cf.kjh.controller.CommonAction;
import cf.kjh.vo.MemberVO;

public class WriteService implements CommonAction {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("POST")) {
			
			String gr 		= req.getParameter("gr");
			String cate 	= req.getParameter("cate");
			String title   	= req.getParameter("subject");
			String content 	= req.getParameter("content");
			String regip   	= req.getRemoteAddr();
			
			HttpSession session = req.getSession();
			MemberVO member = (MemberVO)session.getAttribute("member");
			String uid = member.getUid();
						
			Connection conn = DBConfig.getConnection();
			
			PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_BOARD);
			psmt.setString(1, cate);
			psmt.setString(2, title);
			psmt.setString(3, content);
			psmt.setString(4, uid);			
			psmt.setString(5, regip);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
			
			return "redirect:/list.do?gr="+gr+"&cate="+cate;
			
		}else{
			String gr = req.getParameter("gr");
			String cate = req.getParameter("cate");
			
			req.setAttribute("gr", gr);
			req.setAttribute("cate", cate);
			
			return "/write.jsp";
		}
		
	}

}