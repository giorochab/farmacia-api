package com.giovana.farmacia_api.controller;

import com.giovana.farmacia_api.dto.encomendaDTO.EncomendaRequestDTO;
import com.giovana.farmacia_api.dto.encomendaDTO.EncomendaResponseDTO;
import com.giovana.farmacia_api.service.EncomendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encomendas")
@RequiredArgsConstructor
public class EncomendaController {

    private final EncomendaService encomendaService;

    @PostMapping
    public ResponseEntity<EncomendaResponseDTO> createEncomenda(@Valid @RequestBody EncomendaRequestDTO requestDTO) {
        EncomendaResponseDTO savedEncomenda = encomendaService.saveEncomenda(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEncomenda);
    }

    @GetMapping
    public ResponseEntity<List<EncomendaResponseDTO>> getAllEncomendas() {
        return ResponseEntity.ok(encomendaService.findAllEncomendas());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncomenda(@PathVariable Long id) {
        encomendaService.deleteEncomenda(id);

        return ResponseEntity.noContent().build();
    }
}
