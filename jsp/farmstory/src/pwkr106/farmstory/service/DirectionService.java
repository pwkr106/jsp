package pwkr106.farmstory.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pwkr106.farmstory.controller.CommonAction;


public class DirectionService implements CommonAction {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		return "/introduction/direction.jsp";
	}
	

}
