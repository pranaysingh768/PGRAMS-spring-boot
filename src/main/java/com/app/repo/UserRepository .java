package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserMail(String tempMail);
	
	public User findByUserMailAndUserPassword(String tempPassword,String passTemp);
	
	public List<User> findByUserType(String tempType);
	public List<User> findByUserTypeAndUserAction(String tempType,String action);
	
	public User findByUserId(int id);
}
