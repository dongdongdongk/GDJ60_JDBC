package com.iu.main.Employees;

public class EmployeesMain {

	public static void main(String[] args) throws Exception {
		System.out.println("시작");
		EmployeesController employeesController = new EmployeesController();
		employeesController.start();
		
		System.out.println("종료");
	}
}
