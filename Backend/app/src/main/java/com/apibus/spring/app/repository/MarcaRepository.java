package com.apibus.spring.app.repository;

import com.apibus.spring.app.Model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
  //Metodos incluidos por JpaRepository
  
}
