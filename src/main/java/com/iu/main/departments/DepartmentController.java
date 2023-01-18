package com.iu.main.departments;

import java.util.ArrayList;
import java.util.Scanner;

public class DepartmentController {
	private Scanner sc;
	private DepartmentDAO departmentDAO;
	public DepartmentController() {
		this.sc = new Scanner(System.in);
		this.departmentDAO = new DepartmentDAO();
	}
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서리스트");
			System.out.println("2. 부서상세정보");
			System.out.println("3. 종	 료");
			int select = sc.nextInt();
			
			DepartmentView dv = new DepartmentView();
			switch(select) {
			case 1:
				ArrayList<DepartmentDTO> ar= departmentDAO.getList();
				dv.view(ar);
				break;
			case 2:
				System.out.println("부서 번호 입력");
				select = sc.nextInt();
				departmentDAO.getDetail(select);
				break;
			default:
				check = false;
				break;
			}
		}
	}

}