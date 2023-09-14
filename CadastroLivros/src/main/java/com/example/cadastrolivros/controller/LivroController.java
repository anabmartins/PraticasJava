package com.example.cadastrolivros.controller;
import com.example.cadastrolivros.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import com.example.cadastrolivros.repository.LivroRepository;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }
    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long isbn) {
        try {
            livroRepository.deleteById(isbn);
            return ResponseEntity.ok("Livro deletado com sucesso.");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{isbn}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long isbn, @RequestBody Livro livroAtualizado) {
        if (livroRepository.existsById(isbn)) {
            Livro livro = livroRepository.findById(isbn).get();
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setNome(livroAtualizado.getNome());
            livro.setAno(livroAtualizado.getAno());
            Livro livroAtualizadoBD = livroRepository.save(livro);
            return ResponseEntity.ok(livroAtualizadoBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}