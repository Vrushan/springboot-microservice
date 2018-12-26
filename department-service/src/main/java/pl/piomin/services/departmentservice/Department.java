package pl.piomin.services.departmentservice;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	//private Long id;
	private Long departmentid;
	private String name;
	private Long organisationid;
	private List<Employee> employees=new ArrayList<Employee>();
	
	Department(Long departmentid,Long organisationid,String name)
	{
		this.departmentid=departmentid;
		this.organisationid=organisationid;
		this.name=name;
		
	}

	//public Long getId() {
	//	return id;
	//}

	//public void setId(Long id) {
	//	this.id = id;
	//}
	
	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}
	

	public String getName() {
		return name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	public Long getOrganisationid() {
		return organisationid;
	}

	public void setOrganisationid(Long organisationid) {
		this.organisationid = organisationid;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	

	
	
	

}
