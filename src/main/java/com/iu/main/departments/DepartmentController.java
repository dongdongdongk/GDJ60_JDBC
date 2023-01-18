package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	public DepartmentController() {
		this.sc = new Scanner(System.in);
		this.departmentDAO = new DepartmentDAO();
	}
	public void start() throws Exception {
		boolean check = true;
		ArrayList<DepartmentDTO> ar = null;
		
		while(check) {
			System.out.println("1. 부서리스트");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 부서상세정보");
			System.out.println("4. 종	 료");
			int select = sc.nextInt();
			LocationDAO ar = new LocationDAO();
			DepartmentView dv = new DepartmentView();
			switch(select) {
			case 1:
				 ar= departmentDAO.getList();
				dv.view(ar);
				break;
			case 2:
				System.out.println("부서 번호 입력");
				select = sc.nextInt();
				departmentDAO.getDetail(select);
				break;
			case 3:
				System.out.println("검색할 주소 입력");
				String add = sc.next();
				ArrayList<LocationDTO> ar = locationDAO.getFind(add);
			
			default:
				check = false;
				break;
			}
		}
	}

}
