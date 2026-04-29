package com.apibus.spring.app.repository;

import com.apibus.spring.app.Model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
  // Metodos incluidos por JpaRepository
}
