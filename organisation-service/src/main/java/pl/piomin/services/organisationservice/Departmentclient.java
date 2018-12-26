package pl.piomin.services.organisationservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="department-service")
public interface Departmentclient {
	
	@GetMapping("/organisation/{organisationid}/withDepartments")
	public List<Department> findbyorganisation(@PathVariable("organisationid") Long organisationid);
	
	@GetMapping("/organisation/{organisationid}/withEmployees")
	public List<Department> findorganisationwithemployees(@PathVariable("organisationid") Long organisationid);
	
}
