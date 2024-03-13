package com.travel.planner.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travel.planner.model.TravelPlans;

@Repository
public interface TravelPlansRepo extends JpaRepository<TravelPlans, Integer>{

}
