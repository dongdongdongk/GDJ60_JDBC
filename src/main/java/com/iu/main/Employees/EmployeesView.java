package com.iu.main.Employees;

import java.util.ArrayList;

public class EmployeesView {

	public void view(EmployeesDTO deEmployeesDTO) {
		System.out.println(deEmployeesDTO.getEMPLOYEE_ID());
		System.out.println(deEmployeesDTO.getFIRST_NAME());
		System.out.println(deEmployeesDTO.getJOB_ID());
		System.out.println(deEmployeesDTO.getDEPARTMENT_ID());
	}
	
	public void view(ArrayList<EmployeesDTO>ar) {
		for(EmployeesDTO dto:ar) {
			this.view(dto);
		}
	}
	
	
	
}
