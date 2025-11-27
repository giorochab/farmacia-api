package com.giovana.farmacia_api.repository;

import com.giovana.farmacia_api.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
