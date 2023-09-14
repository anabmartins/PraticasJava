package com.example.cadastrolivros.repository;
import com.example.cadastrolivros.model.Autor;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
}
