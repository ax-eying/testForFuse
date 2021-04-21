package com.hitachi.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import com.hitachi.Car;
import com.hitachi.CarManager;

public class CarManagementTest {

	@Test
	public void testAddCarWhenOwnerExist() throws Exception {
		try {
			Car car = new Car("307", "Peugeot 307", 2003);
			assertTrue(CarManager.addCar("laurent", car));
			assertTrue(CarManager.getCarList("laurent").contains(car));
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testAddCarWhenOwnerNotExist() throws Exception {
		try {
			Car car = new Car("307", "Peugeot 307", 2003);
			assertFalse(CarManager.addCar("hoge", car));
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testGetCarListWhenOwnerExist() throws Exception {
		try {
			List<Car> list = CarManager.getCarList("laurent");
			assertTrue(list != null);
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testGetCarListWhenOwnerNotExist() throws Exception {
		try {
			List<Car> list = CarManager.getCarList("fuga");
			assertTrue(list == null);
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testAddPassenger() {
		try {
			assertTrue(CarManager.addPassenger("laurent", "86", "peter"));
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testAddPassengerOwnerNotExit() {
		try {
			assertFalse(CarManager.addPassenger("hoge", "86", "peter"));
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testAddPassengerCarNotExit() {
		try {
			assertFalse(CarManager.addPassenger("laurent", "fuga", "peter"));
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testGetPassengerOwner() {
		try {
			CarManager.addPassenger("laurent", "86", "peter");
			assertTrue(CarManager.getPassenger("laurent", "86").contains("peter"));
		} finally {
			CarManager.restore();
		}
	}

	@Test
	public void testGetPassengerOwnerNotExsit() {
		try {
			assertTrue(CarManager.getPassenger("hoge", "86")==null);
		} finally {
			CarManager.restore();
		}
	}
	
	@Test
	public void testGetPassengerCarNotExsit() {
		try {
			assertTrue(CarManager.getPassenger("laurent", "fuga")==null);
		} finally {
			CarManager.restore();
		}
	}
	
	@Test
	public void testGetPassengerPassengerExsit() {
		try {
			CarManager.addPassenger("laurent", "86", "peter");
			assertFalse(CarManager.getPassenger("laurent", "86").contains("piyo"));
		} finally {
			CarManager.restore();
		}
	}

}
