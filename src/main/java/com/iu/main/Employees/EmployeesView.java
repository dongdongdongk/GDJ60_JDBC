package com.iu.main.Employees;

import java.util.ArrayList;

public class EmployeesView {

	public void view(EmployeesDTO_1 deEmployeesDTO) {
		System.out.println(deEmployeesDTO.getEMPLOYEE_ID());
		System.out.println(deEmployeesDTO.getFIRST_NAME());
		System.out.println(deEmployeesDTO.getJOB_ID());
		System.out.println(deEmployeesDTO.getDEPARTMENT_ID());
	}
	
	public void view(ArrayList<EmployeesDTO_1>ar) {
		for(EmployeesDTO_1 dto:ar) {
			this.view(dto);
		}
	}
	
	
	
}
