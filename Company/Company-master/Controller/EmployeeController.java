package com.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Dto.EmployeeDTO;
import com.Services.EmployeeServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "EmployeeController")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServices employeeServices;

	@ApiOperation(value = "addEmployee")
	@PostMapping("/addEmployee")
	public ResponseEntity addEmployeeToCompany(@RequestBody EmployeeDTO employeeDTO) throws Exception {
		employeeServices.save(employeeDTO);
		return ResponseEntity.ok(Optional.empty());
	}

	@ApiOperation(value = "deleteEmployee")
	@DeleteMapping("/deleteEmployee/{id}")
	public HttpStatus deleteCompanyEmployee(@PathVariable("id") Integer id) throws Exception {
		{
			employeeServices.deleteCompanyEmployee(id);
			return HttpStatus.FORBIDDEN;
		}
	}
}
