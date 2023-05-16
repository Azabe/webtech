package com.example.groupspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.groupspring.model.Matchday;

@Repository
public interface MatchdayRepository extends JpaRepository<Matchday, String> {

}
