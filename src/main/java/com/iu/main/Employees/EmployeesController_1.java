package com.iu.main.Employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesController_1 {

	private Scanner sc;
	EmployeesDAO_1 employeesDAO = new EmployeesDAO_1();
	ArrayList<EmployeesDTO_1> en = null;
	EmployeesView ev = new EmployeesView();
	public EmployeesController_1() {
		this.sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean check = true;
		while(check) {
			System.out.println("1.사원정보리스트");
			System.out.println("2.개별사원정보");
			System.out.println("3.사원검색");
			System.out.println("4.종료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				en = employeesDAO.getlist();
				ev.view(en);
				break;
			case 2:
				System.out.println("사원번호 입력");
				int id = sc.nextInt();
				employeesDAO.getalllist(id);
				break;	
			case 3:
				System.out.println("사원이름 입력");
				String name = sc.next();
				employeesDAO.getalllistn(name);
				break;
			default :
				check = false;
				break;
			}	
		}
	}
}
