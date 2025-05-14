package com.Grupo4.editar_meus_dados.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {
        // Método para obter os dados do usuário
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody Object dadosAtualizados) {
        // Método para atualizar os dados do usuário
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/nucleos")
    public ResponseEntity<?> getNucleos(@PathVariable Long id) {
        // Método para listar núcleos de conhecimento do usuário
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/turmas")
    public ResponseEntity<?> getTurmas(@PathVariable Long id) {
        // Método para listar turmas associadas ao usuário
        return ResponseEntity.ok().build();
    }

}