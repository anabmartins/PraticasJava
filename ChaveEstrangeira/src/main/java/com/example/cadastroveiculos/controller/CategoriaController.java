package com.example.cadastroveiculos.controller;
import com.example.cadastroveiculos.model.Categoria;
import com.example.cadastroveiculos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/categorias")
public class CategoriaController {
 @Autowired
    private CategoriaRepository categoriaRepository;
 @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
   @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
