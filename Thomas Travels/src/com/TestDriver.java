package com;

import java.util.ArrayList;

public class TestDriver {

	public static void main(String[] args) {
		Driver driver=new Driver(100,"Car","Sukhesh",9999);
		
		Travel travel =new Travel();
	
	
		boolean isCarDriver= travel.isCarDriver(driver);
		System.out.println(isCarDriver);
		System.out.println();
		
		Driver driver1=new Driver(100,"Lorry","Ramesh",9999);
		Driver driver2=new Driver(101,"Car","Suresh",555);
		Driver driver3=new Driver(999,"Car","Harish",8888);
		Driver driver4=new Driver(102,"Truck","Mukesh",8987);
		Driver driver5=new Driver(104,"Lorry","Satish",8982);
		Driver driver6=new Driver(105,"Truck","Paramesh",10000);
		Driver driver7=new Driver(106,"Car","Jithesh",8981);
		
		// retriveByDriverId
		ArrayList<Driver> totalDriversList=new ArrayList<Driver>();
		totalDriversList.add(driver1);
		totalDriversList.add(driver2);
		totalDriversList.add(driver3);
		totalDriversList.add(driver4);
		totalDriversList.add(driver5);
		totalDriversList.add(driver6);
		totalDriversList.add(driver7);
		
		travel.retriveByDriverId(totalDriversList, 102);
		System.out.println();
		// retrive drivers category and returns count

		int driversCount=travel.retriveCountOfDriver(totalDriversList, "Car");
		System.out.println("Driver count is "+driversCount);
		System.out.println();
	
		// retriveDriver returns batch as a separate union
	
		travel.retriveDriver(totalDriversList, "Car");
		 System.out.println();
		
		// retrive maximum distance travelled
		
	Driver topDriver=	travel.retrieveMaximumDistanceTravelledDriver(totalDriversList);
		
		System.out.println(topDriver);
		
		
			}



}

