package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) throws Exception {
		System.out.println("start");
		
		DepartmentController dc = new DepartmentController();
		//LocationController ld = new LocationController();
		try {
			dc.start();
			//dao.getList();
			//dao.getDetail(2110);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		LocationDAO ldao = new LocationDAO();
//		try {
//			//ldao.getList();
//			ldao.getDetail(1900);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("finish");
	}
}
