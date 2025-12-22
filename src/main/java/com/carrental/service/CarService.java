package com.carrental.service;

import java.util.List;

import com.carrental.entities.Cars;

public interface CarService {
	public Cars saveCar(Cars car);
	public List<Cars> getAllCars();
	public String deleteCar(String carName);
	public String updateCar(String oldCarName, Cars updatedCars);
	public Cars getCarById(int id);
	public Cars findByCarName(String carName);
	public List<Cars>findBySeatAndCategory(int seats, String segment);
}
