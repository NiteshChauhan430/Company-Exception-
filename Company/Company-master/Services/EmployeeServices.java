package com.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.Dto.EmployeeDTO;
import com.Enitities.Company;
import com.Enitities.CompanyEmployee;
import com.Exception.InvalidRequestException;
import com.Repository.CompanyRepository;
import com.Repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	private void validateCompanyEmployeeDTO(EmployeeDTO employeeDTO) throws InvalidRequestException {

		if (ObjectUtils.isEmpty(employeeDTO.getName())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(employeeDTO.getAadhar())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(employeeDTO.getAddress())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(employeeDTO.getCompId())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(employeeDTO.getAddress().getAd1())) {
			throw new InvalidRequestException();
		}

		if (ObjectUtils.isEmpty(employeeDTO.getAddress().getAd2())) {
			throw new InvalidRequestException();
		}

		if (ObjectUtils.isEmpty(employeeDTO.getAddress().getPin())) {
			throw new InvalidRequestException();
		}

		if (ObjectUtils.isEmpty(employeeDTO.getAddress().getCountry())) {
			throw new InvalidRequestException();
		}
	}

	public CompanyEmployee dtoToEnitity(EmployeeDTO employeeDTO) throws InvalidRequestException {
		validateCompanyEmployeeDTO(employeeDTO);

		CompanyEmployee companyEmployee = new CompanyEmployee();
		companyEmployee.setAadhar(employeeDTO.getAadhar());
		companyEmployee.setName(employeeDTO.getName());
		companyEmployee.setAddress(employeeDTO.getAddress());
		Optional<Company> company1 = companyRepository.findById(employeeDTO.getCompId());
		if (company1.isPresent()) {
			companyEmployee.setCompany(company1.get());
		} else {
			throw new InvalidRequestException();
		}
		return companyEmployee;
	}

	public void save(EmployeeDTO employeeDTO) throws InvalidRequestException {
		CompanyEmployee ce = dtoToEnitity(employeeDTO);
		employeeRepository.save(ce);
	}

	public void deleteCompanyEmployee(Integer id) throws Exception {

		Optional<CompanyEmployee> companyEmployee = employeeRepository.findById(id);
		if (companyEmployee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new Exception("No Employee found");
		}
	}
}
