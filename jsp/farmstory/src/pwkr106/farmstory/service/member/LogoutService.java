package pwkr106.farmstory.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pwkr106.farmstory.controller.CommonAction;

public class LogoutService implements CommonAction {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/farmstory/index.do";
	}

}
