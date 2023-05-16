package com.example.groupspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.groupspring.model.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
	
}
