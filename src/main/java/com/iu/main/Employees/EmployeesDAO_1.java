package com.iu.main.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class EmployeesDAO_1 {

	public ArrayList<EmployeesDTO_1> getlist() throws Exception {
		ArrayList<EmployeesDTO_1> ar = new ArrayList<EmployeesDTO_1>();
		Connection connection =DBConnection.getConnection();
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, JOB_ID, DEPARTMENT_ID  FROM EMPLOYEES ORDER BY HIRE_DATE ASC";
		PreparedStatement st = connection.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			EmployeesDTO_1 employeesDTO = new EmployeesDTO_1();
			employeesDTO.setEMPLOYEE_ID(rs.getInt("EMPLOYEE_ID"));
			employeesDTO.setFIRST_NAME(rs.getString("FIRST_NAME"));
			employeesDTO.setJOB_ID(rs.getString("JOB_ID"));
			employeesDTO.setDEPARTMENT_ID(rs.getInt("DEPARTMENT_ID"));
			ar.add(employeesDTO);	
		}
		return ar;
	}
	public void getalllist(int employee_id) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE ?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1,"%"+employee_id +"%");
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt("employee_id"));
			System.out.println(rs.getString("FIRST_NAME"));
			System.out.println(rs.getString("LAST_NAME"));
			System.out.println(rs.getString("EMAIL"));
			System.out.println(rs.getString("PHONE_NUMBER"));
			System.out.println(rs.getDate("HIRE_DATE"));
			System.out.println(rs.getString("JOB_ID"));
			System.out.println(rs.getInt("SALARY"));
			System.out.println(rs.getDouble("COMMISSION_PCT"));
			System.out.println(rs.getInt("MANAGER_ID"));
			
		}else {
			System.out.println("데이터가 없다");
		}
	}
		
		public void getalllistn(String LAST_NAME) throws Exception {
			Connection connection = DBConnection.getConnection();
			String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1,"%"+LAST_NAME +"%");
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("employee_id"));
				System.out.println(rs.getString("FIRST_NAME"));
				System.out.println(rs.getString("LAST_NAME"));
				System.out.println(rs.getString("EMAIL"));
				System.out.println(rs.getString("PHONE_NUMBER"));
				System.out.println(rs.getDate("HIRE_DATE"));
				System.out.println(rs.getString("JOB_ID"));
				System.out.println(rs.getInt("SALARY"));
				System.out.println(rs.getDouble("COMMISSION_PCT"));
				System.out.println(rs.getInt("MANAGER_ID"));
				
			}else {
				System.out.println("이름없음");
			}
	}
	
}
