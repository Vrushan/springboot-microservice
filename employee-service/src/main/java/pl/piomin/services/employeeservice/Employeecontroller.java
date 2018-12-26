package pl.piomin.services.employeeservice;

import java.util.List;


import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/employee")
public class Employeecontroller {
	
	@Autowired
	Employeerepository emprepository;
	
	@PostMapping(value="/add",headers="Accept=application/json")
	public Employee add(@RequestBody Employee employee)
	{
		return emprepository.add(employee);
	}
	@GetMapping(value="/",headers="Accept=application/json")
	public List<Employee> findall()
	{
		return emprepository.findall();
	}
	@GetMapping(value="/department/{departmentid}",headers="Accept=application/json")
	public List findbydepartment(@PathVariable("departmentid") Long departmentid)
	{
		return emprepository.departmentby(departmentid);
	}
	@GetMapping(value="/organisation/{organisationid}",headers="Accept=application/json")
	public List findbyorganisation(@PathVariable("organisationid") Long organisationid)
	{
	return emprepository.organisationby(organisationid);	
	}
	
	@GetMapping(value="/{id}",headers="Accept=application/json")
	public Employee findbyid(@PathVariable("id") Long id)
	{
		return emprepository.findbyid(id);
	}

}
