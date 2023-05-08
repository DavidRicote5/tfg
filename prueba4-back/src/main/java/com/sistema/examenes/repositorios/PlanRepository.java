package com.sistema.examenes.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.examenes.modelo.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
