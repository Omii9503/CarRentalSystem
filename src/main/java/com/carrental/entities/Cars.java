package com.carrental.entities;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cars {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@NotNull
	public String img;
	@NotNull
	public String carName;
	@NotNull
	public long price;
	@NotNull
	public String category;
	@NotNull
	public int seat;
	@NotNull
	public int door;
	@NotNull
	public String transmission;
	@NotNull
	public String ac;
	@NotNull
	public String fuel;
	@NotNull
	public String color;
	@NotNull
	public String groundClearance;
	@NotNull
	public String bootspace;
	@NotNull
	public String torque;
	@NotNull
	public String engine;
	
	public String cimage1;
	public String cimage2;
	public String cimage3;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGroundClearance() {
		return groundClearance;
	}
	public void setGroundClearance(String groundClearance) {
		this.groundClearance = groundClearance;
	}
	public String getBootspace() {
		return bootspace;
	}
	public void setBootspace(String bootspace) {
		this.bootspace = bootspace;
	}
	public String getTorque() {
		return torque;
	}
	public void setTorque(String torque) {
		this.torque = torque;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getCimage1() {
		return cimage1;
	}
	public void setCimage1(String cimage1) {
		this.cimage1 = cimage1;
	}
	public String getCimage2() {
		return cimage2;
	}
	public void setCimage2(String cimage2) {
		this.cimage2 = cimage2;
	}
	public String getCimage3() {
		return cimage3;
	}
	public void setCimage3(String cimage3) {
		this.cimage3 = cimage3;
	}
	@Override
	public String toString() {
		return "Cars [id=" + id + ", img=" + img + ", carName=" + carName + ", price=" + price + ", category="
				+ category + ", seat=" + seat + ", door=" + door + ", transmission=" + transmission + ", ac=" + ac
				+ ", fuel=" + fuel + ", color=" + color + ", groundClearance=" + groundClearance + ", bootspace="
				+ bootspace + ", torque=" + torque + ", engine=" + engine + ", cimage1=" + cimage1 + ", cimage2="
				+ cimage2 + ", cimage3=" + cimage3 + "]";
	}
	public Cars(int id, @NotNull String img, @NotNull String carName, @NotNull long price, @NotNull String category,
			@NotNull int seat, @NotNull int door, @NotNull String transmission, @NotNull String ac,
			@NotNull String fuel, @NotNull String color, @NotNull String groundClearance, @NotNull String bootspace,
			@NotNull String torque, @NotNull String engine, String cimage1, String cimage2, String cimage3) {
		super();
		this.id = id;
		this.img = img;
		this.carName = carName;
		this.price = price;
		this.category = category;
		this.seat = seat;
		this.door = door;
		this.transmission = transmission;
		this.ac = ac;
		this.fuel = fuel;
		this.color = color;
		this.groundClearance = groundClearance;
		this.bootspace = bootspace;
		this.torque = torque;
		this.engine = engine;
		this.cimage1 = cimage1;
		this.cimage2 = cimage2;
		this.cimage3 = cimage3;
	}
	public Cars() {
		super();
		// TODO Auto-generated constructor stub
	}
}
