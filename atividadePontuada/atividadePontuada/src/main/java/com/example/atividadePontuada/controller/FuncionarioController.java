package com.example.atividadePontuada.controller;

import com.example.atividadePontuada.model.Funcionario;
import com.example.atividadePontuada.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<Funcionario> listarTodos(){
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Usuário criado com sucesso"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.atualizar(funcionario);
        return ResponseEntity.ok().body(Map.of("mensagem", "Usuário atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        funcionarioService.excluir(id);
        return ResponseEntity.ok().body(Map.of("mensagem", "Usuário deletado com sucesso"));
    }
}
