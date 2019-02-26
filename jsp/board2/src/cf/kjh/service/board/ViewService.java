package cf.kjh.service.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.kjh.controller.CommonAction;
import cf.kjh.vo.BoardVO;
import cf.kjh.config.DBConfig;
import cf.kjh.config.SQL;

public class ViewService implements CommonAction {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String seq = req.getParameter("seq");
		
		Connection conn = DBConfig.getConnection();
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_VIEW_WITH_FILE);
		psmt.setString(1, seq);
		
		ResultSet rs = psmt.executeQuery();
		BoardVO vo = new BoardVO();
		
		if(rs.next()){
			vo.setSeq(rs.getInt(1));
			vo.setParent(rs.getInt(2));
			vo.setComment(rs.getInt(3));
			vo.setCate(rs.getString(4));
			vo.setTitle(rs.getString(5));
			vo.setContent(rs.getString(6));
			vo.setFile(rs.getInt(7));
			vo.setHit(rs.getInt(8));
			vo.setUid(rs.getString(9));
			vo.setRegip(rs.getString(10));
			vo.setRdate(rs.getString(11));

			vo.setOldName(rs.getString("oldName"));
			vo.setNewName(rs.getString("newName"));
			vo.setDownload(rs.getInt("download"));
		}
		
		rs.close();
		psmt.close();		
		conn.close();

		req.setAttribute("vo", vo);
		
		return "/view.jsp";
	}

}
