package com.example.cadastroveiculos.controller;
import com.example.cadastroveiculos.model.Veiculo;
import com.example.cadastroveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;
    @GetMapping
    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }
    @PostMapping
    public Veiculo criarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
    @DeleteMapping("/{placa}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable String placa) {
        try {
            veiculoRepository.deleteById(placa);
            return ResponseEntity.ok("Veiculo deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{placa}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable String placa, @RequestBody Veiculo veiculoAtualizado) {
        if (veiculoRepository.existsById(placa)) {
            Veiculo veiculo = veiculoRepository.findById(placa).get();
            veiculo.setPlaca(veiculoAtualizado.getPlaca());
            veiculo.setCor(veiculoAtualizado.getCor());
            veiculo.setFabricante(veiculoAtualizado.getFabricante());
            veiculo.setModelo(veiculoAtualizado.getModelo());
            veiculo.setCategoria(veiculoAtualizado.getCategoria());
            veiculo.setAno(veiculoAtualizado.getAno());
            Veiculo veiculoAtualizadoBD = veiculoRepository.save(veiculo);
            return ResponseEntity.ok(veiculoAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
