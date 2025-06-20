package com.Grupo4.editar_meus_dados.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference; // IMPORTAR

@Entity
@Table(name = "informacoes")
public class Informacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailSecundario;

    private String curriculoLattes;

    private String telefone;

    private LocalDateTime ultimoAcesso;

    @OneToOne(mappedBy = "informacoes")
    @JsonBackReference
    private Usuario usuario;

    // Construtores
    public Informacoes() {
    }

    public Informacoes(String emailSecundario, String curriculoLattes, String telefone, LocalDateTime ultimoAcesso) {
        this.emailSecundario = emailSecundario;
        this.curriculoLattes = curriculoLattes;
        this.telefone = telefone;
        this.ultimoAcesso = ultimoAcesso;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getCurriculoLattes() {
        return curriculoLattes;
    }

    public void setCurriculoLattes(String curriculoLattes) {
        this.curriculoLattes = curriculoLattes;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}