package com.getfit.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.getfit.modelo.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
