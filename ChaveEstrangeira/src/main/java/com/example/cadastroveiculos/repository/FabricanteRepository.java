package com.example.cadastroveiculos.repository;
import com.example.cadastroveiculos.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
