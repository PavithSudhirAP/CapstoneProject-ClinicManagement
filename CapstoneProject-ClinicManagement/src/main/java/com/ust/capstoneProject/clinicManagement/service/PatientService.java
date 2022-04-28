package com.ust.capstoneProject.clinicManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.capstoneProject.clinicManagement.entity.PatientEntity;
import com.ust.capstoneProject.clinicManagement.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository pr;
	
	public void patientRegistration(PatientEntity patient) {
		pr.save(patient);
	}
	
	public List<PatientEntity> getAllPatient() {
		return pr.findAll();
	}
	
	public PatientEntity getPatientById(String pid) {
		Optional<PatientEntity> patient= pr.findById(pid);
		if(patient.isPresent()) {
			return patient.get();
		}
		return null;
	}
	
	public void deletePatient(String pid) {
		pr.deleteById(pid);
	}
}
