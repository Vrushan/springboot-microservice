package pl.piomin.services.organisationservice;

import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private Long id;
	private String name;
	private Long organisationid;
	private List<Employee> employees=new ArrayList<Employee>();
	
	public Department(Long id, Long organisationid, String name)
	{
		this.id=id;
		this.organisationid=organisationid;
		this.name=name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Long getOrganisationid() {
		return organisationid;
	}

	public void setOrganisationid(Long organisationid) {
		this.organisationid = organisationid;
	}
	
	

}
