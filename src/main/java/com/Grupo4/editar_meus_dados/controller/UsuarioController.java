package com.Grupo4.editar_meus_dados.controller;

import com.Grupo4.editar_meus_dados.dto.UsuarioUpdateDto;
import com.Grupo4.editar_meus_dados.model.Usuario;
import com.Grupo4.editar_meus_dados.service.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) {

        Usuario usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioUpdateDto dadosAtualizados) {

        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, dadosAtualizados);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @GetMapping("/{id}/nucleos")
    public ResponseEntity<?> getNucleos(@PathVariable Long id) {

        return ResponseEntity.ok().body("Funcionalidade de listar núcleos para o usuário " + id + " a ser implementada.");
    }

    @GetMapping("/{id}/turmas")
    public ResponseEntity<?> getTurmas(@PathVariable Long id) {

        return ResponseEntity.ok().body("Funcionalidade de listar turmas para o usuário " + id + " a ser implementada.");
    }

}

