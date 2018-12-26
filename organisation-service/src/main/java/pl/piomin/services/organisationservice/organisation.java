package pl.piomin.services.organisationservice;

import java.util.ArrayList;
import java.util.List;

public class organisation {
	
	private Long id;
	private Long organisationid;
	private String name;
	private String address;
	private List<Department> departments=new ArrayList<Department>();
	private List<Employee> employees = new ArrayList<Employee>();
	
	
	organisation(long id,Long organisationid,String name,String address)
	{
		this.id=id;
		this.organisationid=organisationid;
		this.name=name;
		this.address=address;
	}
	
	


	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Long getOrganisationid() {
		return organisationid;
	}


	public void setOrganisationid(Long organisationid) {
		this.organisationid = organisationid;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Department> getDepartments() {
		return departments;
	}


	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	

}
