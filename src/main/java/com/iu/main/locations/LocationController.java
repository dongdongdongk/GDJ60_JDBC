package com.iu.main.locations;

import java.util.ArrayList;
import java.util.Scanner;

public class LocationController {

private Scanner sc;
private LocationDAO locationDAO;
	public LocationController() {
		this.sc = new Scanner(System.in);
		this.locationDAO = new LocationDAO();
	}
	
	public void start() throws Exception {
		boolean ck = true;
		while(ck) {
			System.out.println("1. 로케이션리스트");
			System.out.println("2. 로케이션상세정보");
			System.out.println("3. 종	 료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				//locationDAO.getList();
				ArrayList<LocationDTO> ar = locationDAO.getList();
				break;
			case 2:
				System.out.println("로케이션 번호입력");
				select = sc.nextInt();
				locationDAO.getDetail(select);
				break;
			default:
				ck = false;
				break;
				
			}
			
		}
	}
}
