package com.ExamGuruOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExamGuruOnline.entity.OrganizationDetails;

@Repository
public interface OrganizationDetailsRepo extends JpaRepository<OrganizationDetails, Long>{

}
