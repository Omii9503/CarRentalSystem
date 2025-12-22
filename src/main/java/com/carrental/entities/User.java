package com.carrental.entities;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@NotNull
	public String name;
	@NotNull
	public long mobNo;
	@NotNull
	public String email;
	@NotNull
	public String aadharNo;
	@NotNull
	public String licenseNo;
	@NotNull
	public String address;
	@NotNull
	public String state;
	@NotNull
	public String carModel;
	@NotNull
	public String pickUp;
	@NotNull
	public String dropUp;
	@NotNull
	public int days;
	public String query;
	
	@NotNull
	public int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobNo() {
		return mobNo;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getDropUp() {
		return dropUp;
	}

	public void setDropUp(String dropUp) {
		this.dropUp = dropUp;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", mobNo=" + mobNo + ", email=" + email + ", aadharNo=" + aadharNo
				+ ", licenseNo=" + licenseNo + ", address=" + address + ", state=" + state + ", carModel=" + carModel
				+ ", pickUp=" + pickUp + ", dropUp=" + dropUp + ", days=" + days + ", query=" + query + ", price="
				+ price + "]";
	}

	public User(int id, @NotNull String name, @NotNull long mobNo, @NotNull String email, @NotNull String aadharNo,
			@NotNull String licenseNo, @NotNull String address, @NotNull String state, @NotNull String carModel,
			@NotNull String pickUp, @NotNull String dropUp, @NotNull int days, String query, @NotNull int price) {
		super();
		this.id = id;
		this.name = name;
		this.mobNo = mobNo;
		this.email = email;
		this.aadharNo = aadharNo;
		this.licenseNo = licenseNo;
		this.address = address;
		this.state = state;
		this.carModel = carModel;
		this.pickUp = pickUp;
		this.dropUp = dropUp;
		this.days = days;
		this.query = query;
		this.price = price;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
