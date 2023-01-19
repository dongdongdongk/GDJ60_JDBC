package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {

	private Scanner sc;
	
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		System.out.println("LOCATION_ID 입력");
		locationDTO.setLocation_id(sc.nextInt());
		System.out.println("STREET_ADDRESS 입력");
		locationDTO.setStreet_address(sc.next());
		System.out.println("POSTAL_CODE 입력");
		locationDTO.setPostal_code(sc.next());
		System.out.println("CITY 입력");
		locationDTO.setCity(sc.next());
		System.out.println("STATE_PROVINCE 입력");
		locationDTO.setState_province(sc.next());
		System.out.println("COUNTRY_ID 입력");
		locationDTO.setCountry_id(sc.next());
		return locationDTO;
	}
}
