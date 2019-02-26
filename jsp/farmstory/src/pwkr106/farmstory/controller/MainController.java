package pwkr106.farmstory.controller;

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



public class MainController extends HttpServlet {
	
	private Map<String, Object> instances = new HashMap<>();
	
	private static final long serialVersionUID = 8273884249476412136L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// properties ���ϰ�� ����
		ServletContext ctx = config.getServletContext();
		String path = ctx.getRealPath("/WEB-INF")+"/commandURI.properties";
		// properties ��ü����
		Properties prop = new Properties();
		FileInputStream fis = null;
			
		try {
			// commandURI.properties ���ϰ� ��Ʈ�� ����
			fis = new FileInputStream(path);
			// �Է� ��Ʈ������ CommandURI.properties ���� ������ �б�
			prop.load(fis);
			// ��Ʈ�� ����
			fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// Model Ŭ���� ��ü�� �����ؼ� instances�� ����
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
		// �� ���ڿ� ���� : .startsWith -> �����ϴ� ���ڿ��� (" ")
		if(result.startsWith("redirect:")) {
			
			// �� ���ڿ� ���� : .substring -> �տ������� (n) ��ŭ ����
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
