package com.Enitities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "gstNo")
	private Integer gstNo;

	@Column(name = "ownerName")
	private String ownerName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Address> addr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGstNo() {
		return gstNo;
	}

	public void setGstNo(Integer gstNo) {
		this.gstNo = gstNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Set<Address> getAddr() {
		return addr;
	}

	public void setAddr(Set<Address> addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", gstNo=" + gstNo + ", ownerName=" + ownerName + ", addr="
				+ addr + "]";
	}

}
