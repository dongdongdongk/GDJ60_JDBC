package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	public void getConnection() throws Exception {
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
		
		
		//3. Query문 생성 
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//4. Query문 DB로 미리 전송(미완성)
		PreparedStatement st = connection.prepareStatement(sql);
		
		//5. ? 값 세팅(option)(필요하면 하고 안하면x)
		
		//6.최종 전송 및 결과처리 
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			System.out.println(rs.getInt("DEPARTMENT_ID"));
			System.out.println(rs.getString("DEPARTMENT_NAME"));
			System.out.println(rs.getInt("MANAGER_ID"));
			System.out.println(rs.getInt("LOCATION_ID"));
		}
		//7. 연결 해제 
	
	}
	
}
