package pl.piomin.services.employeeservice;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceApplicationTests {
	
	@Autowired
	private Employeerepository employeerepository;
	
	@MockBean
	private Employeecontroller empcontroller;

	@Test
	public void testbydepartment() {
		
		Employee employee=new Employee(1L,1L, 1L, "John Smith", 34, "Analyst");
		
		
		List<Employee> list = new ArrayList<>();
		list.add(employee);
		
		Mockito.when(empcontroller.findbydepartment(1L)).thenReturn(list);
		assertThat(empcontroller.findbydepartment(1L)).isEqualTo(list);
			
	}
	
	@Test
	public void testbyorganisation() {
		
		Employee employee=new Employee(1L,1L, 1L, "John Smith", 34, "Analyst");
		
		
		List<Employee> list = new ArrayList<>();
		list.add(employee);
		
		Mockito.when(empcontroller.findbyorganisation(1L)).thenReturn(list);
		assertThat(empcontroller.findbyorganisation(1L)).isEqualTo(list);
			
	}

}
