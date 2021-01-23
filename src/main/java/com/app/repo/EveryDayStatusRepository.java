package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.EveryDayStatus;

public interface EveryDayStatusRepository extends JpaRepository<EveryDayStatus, Integer>{

	public List<EveryDayStatus>findBycomplaintId(int cId);
}
