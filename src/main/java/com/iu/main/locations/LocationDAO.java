package com.iu.main.locations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.departments.DepartmentDTO;
import com.iu.main.util.DBConnection;


public class LocationDAO {
	
	public ArrayList<LocationDTO> getFind(String search) throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT  * FROM LOCATIONS WHERE STREET_ADDRESS  LIKE '%?%'"; //앞뒤로 알아서 %%넣어줌
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
		}
	return ar;
	}
	
	
	public void getDetail(int LOCATION_ID) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT  * FROM LOCATIONS WHERE LOCATION_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		//1은 테이블 열
		st.setInt(1, LOCATION_ID);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			
			System.out.println(rs.getInt("LOCATION_ID"));
			System.out.println(rs.getString("STREET_ADDRESS"));
			System.out.println(rs.getString("POSTAL_CODE"));
			System.out.println(rs.getString("CITY"));
			System.out.println(rs.getString("STATE_PROVINCE"));
			System.out.println(rs.getString("COUNTRY_ID"));
		}else {
			System.out.println("데이터가 없음");
		}
	}
	
	
	
	public ArrayList<LocationDTO> getList()throws Exception {
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		//1. 접속 정보 준비 
		
		//2. DB 접속 : 접속객체 받아오기 
		Connection connection = DBConnection.getConnection();
		
		//3. Query문 생성
		String sql = "SELECT  * FROM LOCATIONS";
		//4. Query 미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		//5. ? 세팅
		//6. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLOCATION_ID(rs.getInt("LOCATION_ID"));
			locationDTO.setSTREET_ADDRESS(rs.getString("STREET_ADDRESS"));
			locationDTO.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
			locationDTO.setCITY(rs.getString("CITY"));
			locationDTO.setSTATE_PROVINCE(rs.getString("STATE_PROVINCE"));
			locationDTO.setCOUNTRY_ID(rs.getString("COUNTRY_ID"));
			ar.add(locationDTO);
//			System.out.println(rs.getInt("LOCATION_ID"));
//			System.out.println(rs.getString("STREET_ADDRESS"));
//			System.out.println(rs.getString("POSTAL_CODE"));
//			System.out.println(rs.getString("CITY"));
//			System.out.println(rs.getString("STATE_PROVINCE"));
//			System.out.println(rs.getString("COUNTRY_ID"));
		}
		DBConnection.disConnect(rs, st, connection);
		return ar;
	}
}
