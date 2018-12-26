package pl.piomin.services.departmentservice;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/rest1")
public class departmentcontroller {

	@Autowired
	private departmentclient client;
	@Autowired
	private departmentRepository rep;
	
	@PostMapping(value="/add",headers="Accept=application/json")
	public Department add(@RequestBody Department department)
	{
		return rep.add(department);
	}
	
	@GetMapping(value="/",headers="Accept=application/json")
	public List<Department> findall()
	{
		return rep.findall();
	}
	
	@GetMapping(value="/{departmentid}",headers="Accept=application/json")
	public Department findbyid(@PathVariable("departmentid") Long departmentid)
	{
		return rep.findbyid(departmentid);
	}
	
	
	@GetMapping(value="/organisation/{organisationid}",headers="Accept=application/json")
	public List<Department> findbyorganisation(@PathVariable("organisationid") Long organisationid)
	{
		return rep.findbyorganisation(organisationid);
	}
	
	@GetMapping(value="organisation/{organisationid}/withEmployees",headers="Accept=application/json")
	public List<Department> findorganisationwithemployees(@PathVariable("organisationid") Long organisationid)
	{
		List<Department> departments=rep.findbyorganisation(organisationid);
		
		departments.forEach(a->a.setEmployees(client.findbydepartment(a.getOrganisationid())));
		
		return departments;
	}
	//@GetMapping(value="organisation/{organisationid}/withEmployees",headers="Accept=application/json")
	//public List<Employee> findorganisationwithemployees(@PathVariable("organisationid") Long organisationid)
	//{
		//List<Employee> employees=client.findbydepartment(organisationid);
		
		//return employees;
	//}
	
}
