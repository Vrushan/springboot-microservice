package pl.piomin.services.departmentservice;

import java.util.List;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name="employee-service",fallback=departmentcontroller.class)
public  interface departmentclient {
	
	@GetMapping("/organisation/{organisationid}")
    List<Employee> findbydepartment(@PathVariable("organisationid") Long organisationid);

}
