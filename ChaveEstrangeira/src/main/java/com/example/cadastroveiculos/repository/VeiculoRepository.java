package com.example.cadastroveiculos.repository;
import com.example.cadastroveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
