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
        Usuario usuario = getUsuarioById(id);
        Informacoes informacoes = usuario.getInformacoes();

        // Garante que a entidade Informacoes exista e esteja associada corretamente
        if (informacoes == null) {
            informacoes = new Informacoes();
            usuario.setInformacoes(informacoes); // Associa Informacoes ao Usuario
            informacoes.setUsuario(usuario);     // Associa Usuario a Informacoes (importante para bidirecionalidade)
        }

        // Atualizar os campos editáveis
        // Foto (em Usuario)
        if (dadosAtualizados.getFoto() != null) {
            // Adicionar validação de tamanho e tipo aqui se necessário (RN037x) [cite: 34]
            usuario.setFoto(dadosAtualizados.getFoto());
        }

        // Email Secundário (em Informacoes)
        informacoes.setEmailSecundario(dadosAtualizados.getEmailSecundario());

        // Currículo Lattes (em Informacoes)
        informacoes.setCurriculoLattes(dadosAtualizados.getCurriculoLattes());

        // Telefone (em Informacoes)
        informacoes.setTelefone(dadosAtualizados.getTelefone());

        // Atualiza a data do último acesso/modificação nas informações do usuário
        informacoes.setUltimoAcesso(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }
}