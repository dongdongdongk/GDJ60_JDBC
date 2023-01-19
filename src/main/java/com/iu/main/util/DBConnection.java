package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	//static으로 객체없이 편하게 사용
	public static Connection getConnection() throws Exception {
		//1. 접속 정보 준비 id.pw.url.driver
		
		//1.id
		String username = "hr";
		//2.pw
		String password = "hr";
		//3.url
		//String url = "jdbc:oracle:thin:@ip:port/ServiveName";
		//String url = "jdbc:oracle:thin:@ip:port:SID";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4.driver
		//패키지명 클래스명 (오라클의). . . 찾아들어가는것
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//forName class name 으로 
		Class.forName(driver);
		
		//2.DB 접속 실행
		//DriverManager.getConnection 내용 몰라도 괜찮음 이걸사용하면 DB접속 실행  
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
		
			
		}
	public static void disConnect(PreparedStatement st, Connection connection) throws Exception {
		st.close();
		connection.close();
	}
	
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection connection) throws Exception {
		rs.close();
		st.close();
		connection.close();
	}
	
}
