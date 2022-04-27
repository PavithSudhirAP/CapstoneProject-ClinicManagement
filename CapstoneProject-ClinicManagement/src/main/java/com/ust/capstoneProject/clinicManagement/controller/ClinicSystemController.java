package com.ust.capstoneProject.clinicManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ust.capstoneProject.clinicManagement.entity.PatientEntity;

import com.ust.capstoneProject.clinicManagement.service.PatientService;

@Controller
public class ClinicSystemController {

	@Autowired
	private PatientService pservice;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/addPatient")
	public String addPatientForm() {
		return "addPatient";
	}

	@PostMapping("/addPatients")
	public String patientSave(  @ModelAttribute PatientEntity patient, HttpSession session) {
	
		System.out.println(patient);
		pservice.addPatient(patient);
		session.setAttribute("msg", "Patient added successfully..");
		return "redirect:/viewPatient";
	}

	@GetMapping("/viewPatient")
	public String patientView(Model m) {
		List<PatientEntity> pat = pservice.getAllPatient();
		m.addAttribute("patient", pat);
		return "viewPatient";
	}

	@GetMapping("/updatePatient/{pid}")
	public String patientEdit(@PathVariable String pid, Model m2) {

		PatientEntity patient = pservice.getPatientById(pid);
		m2.addAttribute("patient", patient);
		return "updatePatient";
	}

	@PostMapping("/updatePatients")
	public String patientUpdate(@ModelAttribute PatientEntity p, HttpSession session) {

		pservice.addPatient(p);
		session.setAttribute("msg", "Patient updated successfully..");
		return "redirect:/viewPatient";
	}

	@GetMapping("/deletepat/{pid}")
	public String medDelete(@PathVariable String pid, HttpSession session) {
		pservice.deletePatient(pid);
		session.setAttribute("msg", "Patient deleted successfully..");
		return "redirect:/viewPatient";
	}

}
