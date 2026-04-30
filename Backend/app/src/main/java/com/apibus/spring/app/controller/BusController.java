package com.apibus.spring.app.controller;
import com.apibus.spring.app.dto.BusResponseDTO;
import com.apibus.spring.app.service.BusService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Controlador REST
@RequestMapping("/bus") //Ruta base 
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:5173"})
@RequiredArgsConstructor
public class BusController {
    private final BusService busService;

    /**
    * Endpoint: GET /bus
    * Es para que tenga la lista de los buses
    */
   @GetMapping
   public ResponseEntity<Page<BusResponseDTO>> obtenerBuses(Pageable pageable) {
        Page<BusResponseDTO> buses = busService.obtenerTodosLosBuses(pageable);
        return ResponseEntity.ok(buses);
    }

    /**
    * Endpoint: GET /bus/{id}
    * Llamara a los buses con su informacion con el id
    */
   @GetMapping("/{id}")
   public ResponseEntity<BusResponseDTO> obtenerBusPorId(@PathVariable Long id) {
        BusResponseDTO bus = busService.obtenerBusPorId(id);
        return ResponseEntity.ok(bus);
    }
}
