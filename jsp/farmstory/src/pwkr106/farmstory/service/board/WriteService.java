package pwkr106.farmstory.service.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pwkr106.farmstory.config.DBConfig;
import pwkr106.farmstory.config.SQL;
import pwkr106.farmstory.controller.CommonAction;
import pwkr106.farmstory.vo.MemberVO;

public class WriteService implements CommonAction {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("POST")) {
			
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
			
			return "redirect:/farmstory/board/list.do?"+"&cate="+cate;
			
		}else{
			String cate = req.getParameter("cate");
			
			req.setAttribute("cate", cate);
			
			return "/board/write.jsp";
		}
		
	}

}