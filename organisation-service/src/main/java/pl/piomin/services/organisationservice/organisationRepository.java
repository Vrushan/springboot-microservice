package pl.piomin.services.organisationservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;



@Repository
public class organisationRepository {
	
	private static List<organisation> organisational = new ArrayList<>();
	
	static
	{
		repo();
	}
	
	private  static void repo()
	{
		//organisationRepository repository = new organisationRepository();
		
		organisational.add(new organisation(1L,1L,"Google","los angalis,USA"));
		organisational.add(new organisation(2L,2L,"Cisco","ST.francisco,USA"));
		
		
	}
	
	public organisation add(organisation org)
	{
		org.setOrganisationid((long)organisational.size()+1);
		
		organisational.add(org);
		
		return org;
	}
	
	public List<organisation> getall()
	{
		return organisational;
	}
	
	public organisation findbyid(Long id)
	{
		Optional<organisation> organisation= organisational.stream().filter(a->a.getId().equals(id)).findFirst();
		
		if(organisation.isPresent())
		{
			return organisation.get();
		}
		else
			return null;
	}
	
public List<organisation> findbyorganisation(Long organisationid)
	
	{
		return organisational.stream().filter(a->a.getOrganisationid().equals(organisationid)).collect(Collectors.toList());
	}
	

}
