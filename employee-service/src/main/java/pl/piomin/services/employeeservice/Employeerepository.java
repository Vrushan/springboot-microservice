package pl.piomin.services.employeeservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
@Repository
public class Employeerepository {
	
	private static List<Employee> employees = new ArrayList<>();
	
	static 
	{
		repository();
	}
	
	private static void  repository()
	{
		//Employeerepository emprep=new Employeerepository();
		
		employees.add(new Employee(1L,1L, 1L, "John Smith", 34, "Analyst"));
		employees.add(new Employee(2L,1L, 1L, "Darren Hamilton", 37, "Manager"));
		employees.add(new Employee(3L,1L, 1L, "Tom Scott", 26, "Developer"));
		employees.add(new Employee(4L,1L, 2L, "Anna London", 39, "Analyst"));		
		employees.add(new Employee(5L,1L, 2L, "Patrick Dempsey", 27, "Developer"));
		employees.add(new Employee(6L,2L, 3L, "Kevin Price", 38, "Developer"));		
		employees.add(new Employee(7L,2L, 3L, "Ian Scott", 34, "Developer"));
		employees.add(new Employee(8L,2L, 3L, "Andrew Campton", 30, "Manager"));
		employees.add(new Employee(9L,2L, 4L, "Steve Franklin", 25, "Developer"));
		employees.add(new Employee(10L,2L, 4L, "Elisabeth Smith", 30, "Developer"));
		
	}
       public Employee add(Employee employee)
	{
		employee.setId((long)employees.size()+1);
		employees.add(employee);
		return employee;
		
		
	}
	
	public List<Employee> findall()
	{
		return employees;
	}
	
	
	public List<Employee> departmentby(Long departmentid)
	{
		return employees.stream().filter(a->a.getDepartmentid().equals(departmentid)).collect(Collectors.toList());
	}
	
	public List<Employee> organisationby(Long organisationid)
	{
		return employees.stream().filter(a->a.getOrganisationid().equals(organisationid)).collect(Collectors.toList());
	}
	
	
	public Employee findbyid(Long id)
	{
		Optional<Employee> employee=employees.stream().filter(a->a.getId().equals(id)).findFirst();
		
		if(employee.isPresent())
		{
			return employee.get();
		}
		else 
			return null;
	}
}
