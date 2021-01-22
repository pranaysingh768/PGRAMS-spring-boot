package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Integer>{

}
