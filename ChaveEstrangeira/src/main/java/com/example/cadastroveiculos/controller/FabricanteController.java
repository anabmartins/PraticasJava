package com.example.cadastroveiculos.controller;
import com.example.cadastroveiculos.model.Fabricante;
import com.example.cadastroveiculos.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/fabricantes")
public class FabricanteController {
    @Autowired
    private FabricanteRepository fabricanteRepository;
    @GetMapping
    public List<Fabricante> listarFabricantes() {
        return fabricanteRepository.findAll();
    }
    @PostMapping
    public Fabricante criarFabricante(@RequestBody Fabricante fabricante) {
        return fabricanteRepository.save(fabricante);
    }

}
