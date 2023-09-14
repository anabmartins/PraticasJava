package com.example.cadastrolivros.controller;
import com.example.cadastrolivros.model.Autor;
import com.example.cadastrolivros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/autores")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;
    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }
    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

}

