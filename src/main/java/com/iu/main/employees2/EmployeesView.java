package com.iu.main.employees2;

import java.util.ArrayList;

public class EmployeesView {

	public void view(EmployeesDTO employeesDTO) {
		System.out.println("====================================");
		System.out.println("직업_ID:" + employeesDTO.getJOB_ID());
		System.out.println("이메일:" + employeesDTO.getEMAIL());
		System.out.println("직원_ID:" +employeesDTO.getEMPLOYEE_ID());
		System.out.println("====================================");
		
	}
	
	
	public void view(ArrayList<EmployeesDTO> ar) {
		for(EmployeesDTO employeesDTO : ar) {
			this.view(employeesDTO);
		}
	}
}
