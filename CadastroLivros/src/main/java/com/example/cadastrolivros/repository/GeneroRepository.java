package com.example.cadastrolivros.repository;
import com.example.cadastrolivros.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, String> {
}
