package com.apibus.spring.app.repository;

import com.apibus.spring.app.Model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
  // Metodos incluidos por JpaRepository

  @Query(value = "SELECT b FROM Bus b JOIN FETCH b.marca", 
           countQuery = "SELECT COUNT(b) FROM Bus b")
    Page<Bus> findAll(Pageable pageable);
}
