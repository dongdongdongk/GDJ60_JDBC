package com.iu.main.employees2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeesDAO {

	//월급의 평균
	public void getAvg() throws Exception { 
		Connection connection  = DBConnection.getConnection();
		String sql = "SELECT AVG(SALARY)*12+100 AS A, SUM(SALARY) FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs  = st.executeQuery();
		
		rs.next();
		
		System.out.println(rs.getDouble("A"));
		System.out.println(rs.getInt(2));
		
		
		DBConnection.disConnect(rs, st, connection);
	}
	
	
	
	
	
	public int updateDate(EmployeesDTO employeesDTO) throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql = "UPDATE EMPLOYEES SET JOB_ID = ?, EMAIL = ? WHERE EMPLOYEE_ID = ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1,employeesDTO.getJOB_ID());
		st.setString(2, employeesDTO.getEMAIL());
		st.setInt(3, employeesDTO.getEMPLOYEE_ID());
		int rs = st.executeUpdate();
		DBConnection.disConnect(st, connection);
		return rs;
	}
	
	
	//method 하나에 쿼리 하나 (메서드마다 각각의 쿼리)
	//list 전체검색
	public ArrayList<EmployeesDTO> getList() throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		//1. DB 연결
		Connection connection = DBConnection.getConnection();
		
		//2. Query 문 생성
		String sql = "SELECT JOB_ID, EMAIL, EMPLOYEE_ID  FROM EMPLOYEES"; 
		
		//3. 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//4. ?
		
		//5. 최종 전송 및 결과 처리 
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setEMAIL(rs.getString("EMAIL"));
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			ar.add(employeesDTO);
		}
		//6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	//last_name
	public void getFind(int serch)throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		
		Connection connection  = DBConnection.getConnection();
		
		String sql = "SELECT JOB_ID, EMAIL, EMPLOYEE_ID  FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setInt(1, "%"+serch+"%" );
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {   //한줄 읽어야 데이터를 읽어올수
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setEMAIL(rs.getString("EMAIL"));
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			
			
			
			ar.add(employeesDTO);
		}
		DBConnection.disConnect(rs, st, connection);
	}
}
