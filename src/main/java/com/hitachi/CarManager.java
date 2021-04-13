package com.hitachi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CarManager {

	private static HashMap<String, List<Car>> ownerCar = new HashMap<>();
	private static HashMap<String, HashMap<String, String>> ownerCarPassenger = new HashMap<>();

    static {
    	init();
		System.out.println("initialization completed.");
    }

	private static void init() {
		String owner ="laurent";
		Car car1 = new Car("86", "Toyota GT86", 2020);
		Car car2 = new Car("brz", "Subaru BRZ", 2012);
		Car car3 = new Car("roadster", "Mazda MX-5", 2015);
		List<Car> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		ownerCar.put(owner, list);
		HashMap<String, String> carPassenger = new HashMap<String, String>();
		carPassenger.put(car1.getName(), null);
		carPassenger.put(car2.getName(), null);
		carPassenger.put(car3.getName(), null);
		ownerCarPassenger.put(owner, carPassenger);
	}

	public static boolean addCar(String owner, Car car) {
		if (ownerCar.containsKey(owner)) {
			List<Car> list = ownerCar.get(owner);
			if (Objects.isNull(list)) {
				list = new ArrayList<>();
			}
			list.add(car);
			ownerCar.put(owner, list);
			HashMap<String, String> carPassenger = new HashMap<String, String>();
			carPassenger.put(car.getName(), null);
			ownerCarPassenger.put(owner, carPassenger);
			return true;
		} else {
			return false;
		}
	}

	public static List<Car> getCarList(String owner) {
		if (ownerCar.containsKey(owner)) {
			List<Car> list = ownerCar.get(owner);
			if (!Objects.isNull(list)) {
				return list;
			}
		}
		return null;
	}

	public static boolean addPassenger(String owner, String name, String passenger) {
		if (ownerCarPassenger.containsKey(owner)) {
			HashMap<String, String> carPassenger = ownerCarPassenger.get(owner);
			if (carPassenger.containsKey(name)) {
				carPassenger.put(name, passenger);
				return true;
			}
		}
		return false;
	}

	public static String getPassenger(String owner, String name) {
		if (ownerCarPassenger.containsKey(owner)) {
			HashMap<String, String> carPassenger = ownerCarPassenger.get(owner);
			if (carPassenger.containsKey(name)) {
				return carPassenger.get(name);
			}
		}
		return null;
	}

}
