package com.hitachi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CarManager {

	private static HashMap<String, List<Car>> ownerCar = new HashMap<>();
	private static HashMap<String, HashMap<String, List<String>>> ownerCarPassenger = new HashMap<>();

	static {
		init();
		System.out.println("initialization completed.");
	}

	private static void init() {
		String owner = "laurent";
		Car car1 = new Car("86", "Toyota GT86", 2020);
		Car car2 = new Car("brz", "Subaru BRZ", 2012);
		Car car3 = new Car("roadster", "Mazda MX-5", 2015);
		List<Car> list = new ArrayList<>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		ownerCar.put(owner, list);
		HashMap<String, List<String>> carPassenger = new HashMap<>();
		carPassenger.put(car1.getName(), new ArrayList<>());
		carPassenger.put(car2.getName(), new ArrayList<>());
		carPassenger.put(car3.getName(), new ArrayList<>());
		ownerCarPassenger.put(owner, carPassenger);
	}

	public static boolean addCar(String owner, Car car) {
		if (ownerCar.containsKey(owner)) {
			List<Car> list = ownerCar.get(owner);
			if (Objects.isNull(list)) {
				list = new ArrayList<>();
			}
			list.add(car);
			ownerCar.replace(owner, list);
			HashMap<String, List<String>> carPassenger = ownerCarPassenger.get(owner);
			if (!carPassenger.containsKey(car.getName())) {
				carPassenger.put(car.getName(), new ArrayList<>());
			}
			ownerCarPassenger.replace(owner, carPassenger);
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
			HashMap<String, List<String>> carPassenger = ownerCarPassenger.get(owner);
			if (carPassenger.containsKey(name)) {
				carPassenger.get(name).add(passenger);
				return true;
			}
		}
		return false;
	}

	public static List<String> getPassenger(String owner, String name) {
		if (ownerCarPassenger.containsKey(owner)) {
			HashMap<String, List<String>> carPassenger = ownerCarPassenger.get(owner);
			if (carPassenger.containsKey(name)) {
				return carPassenger.get(name);
			}
		}
		return null;
	}

}
