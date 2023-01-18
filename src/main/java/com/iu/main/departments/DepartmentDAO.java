package com.iu.main.departments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.main.util.DBConnection;

public class DepartmentDAO {
	
	
	public void getDetail(int department_id) throws Exception {
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, department_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			System.out.println(rs.getInt("DEPARTMENT_ID"));
			System.out.println(rs.getString("DEPARTMENT_NAME"));
			System.out.println(rs.getInt("MANAGER_ID"));
			System.out.println(rs.getInt("LOCATION_ID"));
			
		}else {
			System.out.println("Data가 없다");
		}
	}

	public ArrayList<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<DepartmentDTO>();
	
		Connection connection = DBConnection.getConnection();
		
		//3. Query문 생성
		String sql = "SELECT  * FROM DEPARTMENTS";
		//4. Query 미리 전송   : 위에 만든 sql문으로 미리 보내기 
		PreparedStatement st = connection.prepareStatement(sql);
		//5. ? 세팅
		//6. 최종 전송 및 결과 처리  
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			ar.add(departmentDTO);
//			System.out.println(rs.getInt("DEPARTMENT_ID"));
//			System.out.println(rs.getString("DEPARTMENT_NAME"));
//			System.out.println(rs.getInt("MANAGER_ID"));
//			System.out.println(rs.getInt("LOCATION_ID"));
			
		}
		
		//7. 연결 해제 
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
}
