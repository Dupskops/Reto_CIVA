package com.apibus.spring.app.service;

import com.apibus.spring.app.dto.BusResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface BusService {
    Page<BusResponseDTO> obtenerTodosLosBuses(Pageable pageable);

    BusResponseDTO obtenerBusPorId(Long id);

    
}
