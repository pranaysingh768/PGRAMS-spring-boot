package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Complaint;


@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{
	
	public List<Complaint> findByUserId(int userId);
	
	public List<Complaint> findByUserComplaintStatus(String str);
	
	public Complaint findByComplaintId(int id);
	
	public List<Complaint> findByEmployeeIdAndUserComplaintStatus(int empId,String str);
	
	public  List<Complaint>findByComplaintStatus(String status);
	
}
