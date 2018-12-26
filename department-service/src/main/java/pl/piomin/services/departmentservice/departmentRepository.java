package pl.piomin.services.departmentservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.RequestTemplate;

@Repository
public class departmentRepository {
	
	private static  List <Department> list = new ArrayList<Department>();
	
	@Bean
	public RestTemplate restTemplate() {
	
		return new RestTemplate();
    }
	
	@Autowired
	
	RestTemplate restTemplate;
	
	@Autowired
	@Lazy
	private EurekaClient discoveryclient;
	
	@HystrixCommand(fallbackMethod="Hystrixfallback")
	public String fallback()
	{
		return this.restTemplate.getForObject(URI.create(serviceurl()+ "employee"),String.class);
	}
	
	
	public String  serviceurl() {
		
		InstanceInfo instance= discoveryclient.getNextServerFromEureka("employee", false);
		return instance.getHomePageUrl();
	}
	
	public String Hystrixfallback()
	{
		return "oops..!!server failed";
	}


	static 
	{
		department();
	}
	private static void   department()
	{
	//departmentRepository repository = new departmentRepository();
	
		list.add(new Department(1L,1L,"Development"));
		list.add(new Department(2l,1L,"Operation"));
		list.add(new Department(3l,2L,"Devlopment"));
		list.add(new Department(4L,2L,"Operation"));
	
     }
	
	public Department add(Department department)
	{
		//department.set((long)list.size()+1);
		list.add(department);
		 return department;
		
	}
	
	public List<Department> findall()
	{
		return list;
	}
	
	
	public List<Department> findbyorganisation(Long organisationid)
	
	{
		return list.stream().filter(a->a.getOrganisationid().equals(organisationid)).collect(Collectors.toList());
	}
	
	
	public Department findbyid(Long departmentid)
	{
		Optional<Department>department=list.stream().filter(a->a.getDepartmentid().equals(departmentid)).findFirst();
		
		if(department.isPresent())
		{
			return department.get();
		}
		
		else
			return null;
	}
	
	
	

}
