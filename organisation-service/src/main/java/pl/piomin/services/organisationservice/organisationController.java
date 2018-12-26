package pl.piomin.services.organisationservice;

import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
//@RequestMapping("/organisation")
public class organisationController {
	
	@Autowired
	organisationRepository  repository;
	@Autowired
	Departmentclient depclient;
	@Autowired
	Employeeclient empclient;
	
	@PostMapping(value="/add",headers="Accept=application/json")
	public organisation add(@RequestBody organisation org)
	{
		return repository.add(org);
	}
	
	@GetMapping(value="/",headers="Accept=application/json")
	public List<organisation> getall()
	{
		return repository.getall();
	}
	
	@GetMapping("/organisation/{id}")
	public List<organisation> findbyid(@PathVariable("id") Long id)
	{
		return repository.findbyorganisation(id);
	}
	
	
	@GetMapping(value="/organisation/{id}/withDepartments",headers="Accept=application/json")
	public organisation findidwithdepartments(@PathVariable("id") Long id)
	{
		organisation org =repository.findbyid(id);
		org.setDepartments(depclient.findbyorganisation(org.getId()));
		return org;
		
		
	}
		//List<organisation> org = repository.findbyorganisation(organisationid);
		//org.forEach(a->a.setDepartments(depclient.findbyorganisation(a.getOrganisationid())));
		//return org;
	   //org.setDepartments(depclient.findbyorganisation(org.getId()));
		//return org;
		//departments.forEach(a->a.setEmployees(client.findbydepartment(a.getOrganisationid())));
		//List<Department> departments=depclient.findbyorganisation(organisationid);
		//return departments;
	    //List<organisation> org = repository.findbyorganisation(organisationid);
		//org.setDepartments(depclient.findbyorganisation(org.g));
		//return org;
	
	@GetMapping(value="/organisation/{organisationid}/withEmployees",headers="Accept=application/json")
	public organisation findwithemployees(@PathVariable("organisationid") Long organisationid)
	{
		organisation org = repository.findbyid(organisationid);
		org.setEmployees(empclient.findbyorganisation(org.getOrganisationid()));
		return org;
		//List<Employee> employees=empclient.findbyorganisation(organisationid);
	   //return employees;
		
	}
	
	@GetMapping(value="/{id}/with-departments-and-employees",headers="Accept=application/json")
	public organisation findwithdepartmentandemployees(@PathVariable("id") Long id)
	{
		
	    organisation org=repository.findbyid(id);
		org.setDepartments(depclient.findorganisationwithemployees(org.getId()));
	    return org;
		
	}
	
	
	
	
}
