package pl.piomin.services.employeeservice;


public class Employee {
	
	private Long  id;
	private Long  organisationid;
	private Long departmentid;
	private String name;
	private int age;
	private String position;
	
	public Employee()
	{
		
	}
	
	public Employee(Long id,Long organisationid,Long departmentid,String name,int age,String position)
	{
		super();
		this.id=id;
		this.organisationid=organisationid;
		this.departmentid=departmentid;
		this.name=name;
		this.age=age;
		this.position=position;
	}

	public Long  getId() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	

}
