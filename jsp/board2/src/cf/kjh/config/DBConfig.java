package cf.kjh.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

	//�����ͺ��̽� ����
	private static final String HOST = "jdbc:mysql://192.168.0.161:3306/kjh?noAccessToProcedureBodies=true";
	private static final String USER = "kjh";
	private static final String PASS = "1234";
	
	public static Connection getConnection() throws Exception {
		
		// 1�ܰ� - JDBC ����̹� �ε�
		Class.forName("com.mysql.jdbc.Driver");
		// 2�ܰ� - �����ͺ��̽� ����
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		return conn;
	}
	
}
