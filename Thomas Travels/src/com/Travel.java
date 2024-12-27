package com;

import java.util.ArrayList;

public class Travel extends Driver {

	public boolean isCarDriver(Driver driver) {

		return driver.getCategory().equals("Car");
	}

	public String retriveByDriverId(ArrayList<Driver> driverList, int searchingDriverId) {
		for (Driver driver : driverList) {
			int currentDriverId = driver.getDriverId();
			if (currentDriverId == searchingDriverId) {

				String driverName = driver.getDriverName();
				String driverCategory = driver.getCategory();
				double totalDistance = driver.getTotalDistance();
				String response = "Driver name is " + driverName + " Belonging to the category " + driverCategory
						+ " travelled " + totalDistance + " KM so far";
				System.out.println(response);
				return response;
			}
		}

		return "";
	}

	// motham drivers lo car drivers batch enthamandi unaru and
	// lorry batch enthamandi unnaru ani count chepthundi
	public int retriveCountOfDriver(ArrayList<Driver> driverList, String category) {
		int count = 0;
		for (Driver driver : driverList) {
			if (driver.getCategory().equals(category)) {
				count++;
				// System.out.println(driver.getCategory());
			}
		}
		// System.out.println("Count value is " + count);
		return count;
	}

	public ArrayList<Driver> retriveDriver(ArrayList<Driver> driversList, String category) {
		ArrayList<Driver> driverList = new ArrayList<>();

		for (Driver driver : driversList) {

			if (category.equalsIgnoreCase(driver.getCategory())) {

				System.out.println("Batch = " + driver.getCategory() + " Name = " + driver.getDriverName());

				driverList.add(driver);
			}

		}

		return driverList;
	}

	public Driver retrieveMaximumDistanceTravelledDriver(ArrayList<Driver> driverList) {
		Driver topDriver = new Driver();
		if (!driverList.isEmpty()) {
			topDriver = driverList.get(0);
			for (Driver driver : driverList) {
				if (driver.getTotalDistance() > topDriver.getTotalDistance()) {
					topDriver = driver;
				}
			}

		}
		return topDriver;
	}
}


