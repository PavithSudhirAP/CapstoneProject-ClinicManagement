package com.ust.capstoneProject.clinicManagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.capstoneProject.clinicManagement.entity.PatientEntity;

@Repository
public interface PatientRepository extends MongoRepository<PatientEntity, String> {

}