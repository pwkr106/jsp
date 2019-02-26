package cf.kjh.controller;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.kjh.service.member.UserCheckService;

public class MainController extends HttpServlet {
	
	private Map<String, Object> instances = new HashMap<>();
	
	private static final long serialVersionUID = 8273884249476412136L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// properties 파일경로 추출
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF")+"/commandURI.properties";
		// properties 객체생성
		Properties prop = new Properties();
		FileInputStream fis = null;
			
		try {
			// commandURI.properties 파일과 스트림 연결
			fis = new FileInputStream(path);
			// 입력 스트림으로 CommandURI.properties 파일 데이터 읽기
			prop.load(fis);
			// 스트림 해제
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// Model 클래스 객체를 생성해서 instances에 저장
		Iterator it = prop.keySet().iterator();
		
		while(it.hasNext()){
			String k = it.next().toString();
			String v = prop.getProperty(k);
			
			try {
				Class<?> obj = Class.forName(v);
				Object instance = obj.newInstance();
				
				instances.put(k, instance);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestProc(req, resp);
	}
	
	private void requestProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getContextPath();
		String uri 	= req.getRequestURI();
		String action = uri.substring(path.length());
		
		
		CommonAction instance = (CommonAction)instances.get(action);
		String result = null;
		try {
			result = instance.requestProc(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		// ★ 문자열 가공 : .startsWith -> 시작하는 문자열이 (" ")
		if(result.startsWith("redirect:")) {
			
			// ★ 문자열 가공 : .substring -> 앞에서부터 (n) 만큼 제거
			String redirectAddr = result.substring(9);
			resp.sendRedirect(redirectAddr);
			
		}else if(result.startsWith("{")) { //instance instanceof UserCheckService
			PrintWriter out = resp.getWriter();
			out.print(result);
			
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher(result);
			dispatcher.forward(req, resp);
		}
	}
}
