package com.iu.main.employees2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeesDAO {

	//method 하나에 쿼리 하나 (메서드마다 각각의 쿼리)
	//list 전체검색
	public ArrayList<EmployeesDTO> getList() throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		//1. DB 연결
		Connection connection = DBConnection.getConnection();
		
		//2. Query 문 생성
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID "
				+ "FROM EMPLIYEES ORDER BY HIRE_DATE DESC";
		
		//3. 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		
		//4. ?
		
		//5. 최종 전송 및 결과 처리 
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeesDTO.setLAST_NAME(rs.getString("LAST_NAME"));
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setDEPARTMENT_ID(rs.getInt("DEPARTEMENT_ID"));
			ar.add(employeesDTO);
		}
		//6. 연결 해제
		DBConnection.disConnect(rs, st, connection);
		
		return ar;
	}
	
	//last_name
	public void getFind(String serch)throws Exception {
		ArrayList<EmployeesDTO> ar = new ArrayList<EmployeesDTO>();
		
		Connection connection  = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
		PreparedStatement st = connection.prepareStatement(sql);
		
		st.setString(1, "%"+serch+"%" );
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {   //한줄 읽어야 데이터를 읽어올수
			EmployeesDTO employeesDTO = new EmployeesDTO();
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeesDTO.setLAST_NAME(rs.getString("LAST_NAME"));
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setDEPARTMENT_ID(rs.getInt("DEPARTEMENT_ID"));
			employeesDTO.setSALARY(rs.getDouble("SALARY"));
			employeesDTO.setHIRE_DATE(rs.getDate("HIRE_DATE"));
			ar.add(employeesDTO);
		}
		DBConnection.disConnect(rs, st, connection);
	}
}
