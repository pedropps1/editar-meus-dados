package com.Grupo4.editar_meus_dados.dto;

// Adicione as anotações de validação conforme as regras de negócio (RNs) do PDF
// ex: import jakarta.validation.constraints.*;

public class UsuarioUpdateDto {

    private String emailSecundario; // Editável [cite: 7]
    private String curriculoLattes; // Editável (baseado em RN038x e FEX02) [cite: 31, 34]
    private String telefone;        // Editável, com máscara (RN035x) [cite: 7, 34]
    private byte[] foto;            // Editável (arquivo JPG, PNG, máx 5MB - RN037x) [cite: 7, 34]

    // Construtores, Getters e Setters

    public UsuarioUpdateDto() {
    }

    public UsuarioUpdateDto(String emailSecundario, String curriculoLattes, String telefone, byte[] foto) {
        this.emailSecundario = emailSecundario;
        this.curriculoLattes = curriculoLattes;
        this.telefone = telefone;
        this.foto = foto;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}