package cf.kjh.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

	//데이터베이스 정보
	private static final String HOST = "jdbc:mysql://192.168.0.161:3306/kjh?noAccessToProcedureBodies=true";
	private static final String USER = "kjh";
	private static final String PASS = "1234";
	
	public static Connection getConnection() throws Exception {
		
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.jdbc.Driver");
		// 2단계 - 데이터베이스 접속
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		return conn;
	}
	
}
