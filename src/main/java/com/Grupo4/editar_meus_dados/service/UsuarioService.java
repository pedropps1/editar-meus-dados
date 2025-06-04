package com.Grupo4.editar_meus_dados.service;

import com.Grupo4.editar_meus_dados.dto.UsuarioUpdateDto;
import com.Grupo4.editar_meus_dados.model.Informacoes;
import com.Grupo4.editar_meus_dados.model.Usuario;
import com.Grupo4.editar_meus_dados.repository.UsuarioRepository;
import com.Grupo4.editar_meus_dados.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
    }

    @Transactional
    public Usuario atualizarUsuario(Long id, UsuarioUpdateDto dadosAtualizados) {
        // 1. Buscar o usuário existente
        Usuario usuario = getUsuarioById(id);

        // 2. Obter ou criar a entidade Informacoes associada
        Informacoes informacoes = usuario.getInformacoes();
        if (informacoes == null) {
            informacoes = new Informacoes();
            usuario.setInformacoes(informacoes);
            informacoes.setUsuario(usuario);
        }

        // 3. Atualizar os campos editáveis
        if (dadosAtualizados.getFoto() != null) {
            usuario.setFoto(dadosAtualizados.getFoto());
        }

        // Email Secundário (em Informacoes)
        informacoes.setEmailSecundario(dadosAtualizados.getEmailSecundario());

        // Currículo Lattes (em Informacoes)
        informacoes.setCurriculoLattes(dadosAtualizados.getCurriculoLattes());

        // Telefone (em Informacoes)
        informacoes.setTelefone(dadosAtualizados.getTelefone());

        informacoes.setUltimoAcesso(LocalDateTime.now());

        // 4. Salvar o usuário
        return usuarioRepository.save(usuario);
    }

}