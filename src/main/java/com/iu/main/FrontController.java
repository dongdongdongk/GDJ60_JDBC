package com.iu.main;

import java.util.Scanner;

import com.iu.main.locations.LocationController;

public class FrontController {
	private Scanner sc;
	//private DepartmentController departmentController;
	private LocationController locationController;
	
	
	public FrontController() {
		this.sc = new Scanner(System.in);
		//this.departmentController = new DepartmentController();
		this.locationController = new LocationController();
	}
	
	public void start() {
		boolean check = true;
		
		while(check) {
			System.out.println("1. 부서관리");
			System.out.println("2. 지역관리");
			System.out.println("3. 사원관리");
			System.out.println("4. 종  료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1 : 
				break;
			case 2 : 
				break;
			case 3 :
				break;
			default:
				check = false;
			
			}
		}
	}
}
