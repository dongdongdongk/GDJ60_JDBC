package com.iu.main.employees2;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController {

	private Scanner sc;
	private EmployeesDTO employeesDTO;
	private EmployeesDAO employeesDAO;
	private EmployeesView employeesView;
	public EmployeesController() {
		this.sc = new Scanner(System.in);
		this.employeesDTO = new EmployeesDTO();
		this.employeesDAO = new EmployeesDAO();
		this.employeesView = new EmployeesView();
	}
	
	public void start() throws Exception {
		ArrayList<EmployeesDTO> ar = null;
		 EmployeesDTO employeesDTO = null;
		boolean check = true;
		while(check ) {
			System.out.println("1. 직원 리스트");
			System.out.println("2. 직원상세정보");
			System.out.println("3. 직원   추가");
			System.out.println("4. 직원   삭제");
			System.out.println("5. 직원   수정");
			System.out.println("6. 종      료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				ar = employeesDAO.getList();
				employeesView.view(ar);
			case 2:
				System.out.println("직원ID입력");
				select = sc.nextInt();
				employeesDTO = employeesDAO.getFind(select);
				if(employeesDTO != null) {
					employeesView.view(employeesDTO);
				}else {
					System.out.println("데이터가 없다.");
				}
				
			}
		}
	}
}
