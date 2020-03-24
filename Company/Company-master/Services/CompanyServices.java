package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;

import com.Enitities.Company;
import com.Exception.CompanyNotFoundException;
import com.Exception.InvalidRequestException;
import com.Exception.RecordNotFoundException;
import com.Repository.CompanyRepository;

@Service
public class CompanyServices {

	@Autowired
	private CompanyRepository companyRepository;

	public Company add(Company company) throws InvalidRequestException {

		validateCompany(company);
		Optional<Company> company1 = companyRepository.findByGstNo(company.getGstNo());
		if (!company1.isPresent()) {
			companyRepository.save(company);
		} else {
			throw new InvalidRequestException();
		}
		return company;
	}

	private void validateCompany(Company company) throws InvalidRequestException {

		if (ObjectUtils.isEmpty(company.getName())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(company.getGstNo())) {
			throw new InvalidRequestException();
		}
		if (ObjectUtils.isEmpty(company.getOwnerName())) {
			throw new InvalidRequestException();
		}
	}

	public List<Company> findAll() {

		return companyRepository.findAll();
	}

	public Company getCompanyById(@PathVariable Integer id) throws RecordNotFoundException {

		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			return company.get();
		} else {
			throw new RecordNotFoundException();
		}
	}

	public void deleteCompanyById(Integer id) throws Exception {

		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			companyRepository.deleteById(id);
		} else {
			throw new Exception("No Company record exist for given id");
		}
	}

	public Company updateCompanyById(Company company, Integer id) throws Exception {

		validateCompany(company);
		Optional<Company> company2 = companyRepository.findById(id);
		if (company2.isPresent()) {
			company.setId(company2.get().getId());
			companyRepository.save(company);
		} else {
			throw new CompanyNotFoundException();
		}
		return company;
	}

	public List<Company> getAllUserByPin(String pin) {

		List<Company> company = companyRepository.findByAddrPin(pin);
		return company;
	}

}
