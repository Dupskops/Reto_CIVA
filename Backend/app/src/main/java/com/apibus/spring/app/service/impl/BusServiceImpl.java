package com.apibus.spring.app.service.impl;

import com.apibus.spring.app.dto.BusResponseDTO;
import com.apibus.spring.app.Model.Bus;
import com.apibus.spring.app.repository.BusRepository;
import com.apibus.spring.app.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.apibus.spring.app.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) //Leera la base de datos
public class BusServiceImpl implements BusService {
    private final BusRepository busRepository;
    
    @Override
    public Page<BusResponseDTO> obtenerTodosLosBuses(Pageable pageable) {
        // Obtenemos los buses paginados de la base de datos
        Page<Bus> busesPage = busRepository.findAll(pageable);
        
        // map() para transformar cada Entidad Bus en un BusResponseDTO
        return busesPage.map(this::mapearADto);
    }

    @Override
    public BusResponseDTO obtenerBusPorId(Long id) {
        // Busqueda del bus por id
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el bus con ID: " + id));

        return mapearADto(bus);
    }

    /**
     * Método auxiliar privado para centralizar la transformación (Mapeo)
     * de Entidad (Bus) -> DTO (BusResponseDTO)
     */
    private BusResponseDTO mapearADto(Bus bus) {
        return BusResponseDTO.builder()
                .id(bus.getId())
                .numeroBus(bus.getNumeroBus())
                .placa(bus.getPlaca())
                .fechaCreacion(bus.getFechaCreacion())
                .caracteristicas(bus.getCaracteristicas())
                .marca(bus.getMarca().getNombre()) 
                .activo(bus.getActivo())
                .build();
    }
}
