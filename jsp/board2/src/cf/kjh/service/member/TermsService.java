package cf.kjh.service.member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.kjh.config.DBConfig;
import cf.kjh.config.SQL;
import cf.kjh.controller.CommonAction;
import cf.kjh.vo.TermsVO;

public class TermsService implements CommonAction {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {


		Connection conn = DBConfig.getConnection();		
		// 3�ܰ� - �������� ��ü ����
		Statement stmt = conn.createStatement();
		
		// 4�ܰ� - ��������
		ResultSet rs = stmt.executeQuery(SQL.SELECT_TERMS);
		
		// 5�ܰ� - ����� ó��(SELECT ���)
		TermsVO vo = null;
		
		if(rs.next()){
			vo = new TermsVO();
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}
		
		// 6�ܰ� - DB�ڿ� ����
		rs.close();
		stmt.close();
		conn.close();
		
		// request ��ü�� ���� ������ ����
		req.setAttribute("vo", vo);

		return "/terms.jsp";
		
	}
}