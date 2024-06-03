package com.cognizant.rest;
import java.util.List;



import com.cognizant.rest.resources.Patient;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

//
//@Consumes("application/xml, application/json")
//@Produces("application/xml, application/json")


@Path("/patientservice")
public interface PatientService {

	@Path("/patients")
	@GET
	@Produces("application/json")
	List<Patient> getpatients();
	
	@Path("/patients/{id}")
	@GET
	@Produces("application/json")
	@Consumes("application/json")
	Response getPatient(@PathParam("id") Long id);
	
	@Path("/patients")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	Response createPatient(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	Response deletePatient(@PathParam("id") Long id);
	
	@Path("/patients")
	@POST
	@Consumes("application/json , application/x-www-form-urlencoded" )
	void testFormParam(@FormParam("firstName") String firstName,@FormParam("lastName") String lastName);
	
	
}
