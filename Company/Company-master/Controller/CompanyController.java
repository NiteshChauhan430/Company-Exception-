package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Enitities.Company;
import com.Services.CompanyServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CompanyController")
@Controller
public class CompanyController {

	@Autowired
	private CompanyServices companyServices;

	@ApiOperation(value = "add")
	@PostMapping("/add")
	public ResponseEntity<Company> addCompany(@RequestBody Company company) throws Exception {
		return ResponseEntity.ok(companyServices.add(company));
	}

	@ApiOperation(value = "getAll")
	@GetMapping("/getAll")
	public ResponseEntity<List<Company>> findAll() {
		companyServices.findAll();
		return ResponseEntity.ok(companyServices.findAll());
	}

	@ApiOperation(value = "getById")
	@GetMapping("/getById/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Integer id) throws Exception {
		Company company = companyServices.getCompanyById(id);
		return ResponseEntity.of(Optional.of(company));
	}

	@ApiOperation(value = "deleteById")
	@DeleteMapping("/deleteById/{id}")
	public HttpStatus deleteCompanyById(@PathVariable("id") Integer id) throws Exception {
		{
			companyServices.deleteCompanyById(id);
			return HttpStatus.FORBIDDEN;
		}
	}

	@ApiOperation(value = "updateById")
	@PutMapping("/updateById/{id}")
	public ResponseEntity<Company> updateCompanyById(@PathVariable Integer id, @RequestBody Company company)
			throws Exception {
		{
			companyServices.updateCompanyById(company, id);
			return new ResponseEntity<Company>(HttpStatus.OK);

		}
	}

	@ApiOperation(value = "getAllByPin")
	@GetMapping("/getAllByPin/{pin}")
	public ResponseEntity<Object> getAllCompanyByPin(@PathVariable("pin") String pin) throws Exception {

		Object company = companyServices.getAllUserByPin(pin);
		return ResponseEntity.of(Optional.of(company));
	}
}
