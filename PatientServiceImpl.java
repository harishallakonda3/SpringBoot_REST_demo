package com.cognizant.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cognizant.rest.resources.Patient;

import jakarta.ws.rs.core.Response;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patients = new HashMap<>();
	long currentId = 1;

	public PatientServiceImpl() {
		
		init();

	}
	
	public  void init()
	{
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("Harish");
		patients.put(currentId, patient);
	}

	@Override
	public List<Patient> getpatients() {
		Collection<Patient> result = patients.values();
		List<Patient> response = new ArrayList<>(result);
		return response;
//		System.out.println("hiii");
//		return new ArrayList<>(patients.values());

	}

	@Override
	public Response getPatient(Long id) {
		
		 Patient patient = patients.get(id);
		
		 if(patient == null)
		 {
			return Response.status(404).build();
		 }
		 return Response.ok(patient).build();
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(currentId, patient);
		
		return Response.ok(patient).build();
	}

	@Override
	public Response deletePatient(Long id) {
		
		Patient patient = patients.get(id);
		
		if(patient != null)
		{
			patients.remove(id);
			return Response.ok().build();
		}
		
		return Response.status(404).build();
	}

	@Override
	public void testFormParam(String firstName, String lastName) {
		
		System.out.println(firstName+"-"+ lastName);
		
	}

}
