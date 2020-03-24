package com.Dto;

import com.Enitities.Address;

public class EmployeeDTO {

	private Integer compId;

	private String name;

	private Long aadhar;

	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCompId() {
		return compId;
	}

	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	public Long getAadhar() {
		return aadhar;
	}

	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [name=" + name + ", compId=" + compId + ", aadhar=" + aadhar + ", address=" + address + "]";
	}

}
