package com.carrental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.carrental.entities.Cars;
import com.carrental.repository.CarsRepository;


@Service
public class CarServiceImpl implements CarService {
	@Autowired
	public CarsRepository carsRepository;
	@Override
	public List<Cars> getAllCars() {
		List<Cars> result=carsRepository.findAll();
		return result;
	}

	public Cars saveCar(Cars car) {
		return carsRepository.save(car);
	}
	
	@Override
	public String updateCar(String oldCarName, Cars updatedCars) {
		Cars existingCars=carsRepository.findByCarName(oldCarName);
		if(existingCars!=null) {
			existingCars.setAc(updatedCars.getAc());
			existingCars.setCarName(updatedCars.getCarName());
			existingCars.setCategory(updatedCars.getCategory());
			existingCars.setDoor(updatedCars.getDoor());
			existingCars.setImg(updatedCars.getImg());
			existingCars.setPrice(updatedCars.getPrice());
			existingCars.setSeat(updatedCars.getSeat());
			existingCars.setTransmission(updatedCars.getTransmission());
			
			carsRepository.save(existingCars);
		    return "FIND";
	     }else {
		    return "NOTFIND";
	  }
   }
	
	
	@Override
	@Transactional
	public String deleteCar(String carName) {
		if(carsRepository.existsByCarName(carName)) {
			carsRepository.deleteByCarName(carName);
			return "EXIST";
		}
		return "NOTEXIST";
	}
	
	public Cars getCarById(int id) {
		return carsRepository.findById(id).orElse(null);
	}
	
	
	public List<Cars>findBySeatAndCategory(int seats, String segment){
		return this.carsRepository.findBySeatAndCategory(seats, segment);
	}

	@Override
	public Cars findByCarName(String carName) {
		return this.carsRepository.findByCarName(carName);
	}
}
