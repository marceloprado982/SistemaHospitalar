package br.com.sistema.hospitalar.dto;

import br.com.sistema.hospitalar.entities.PacienteEntity;

public class PacienteDTO {

    private Long id;

    private String nome;

    private String telefone;

    private String dataNascimento;

    public  PacienteDTO(){

    }

    public PacienteDTO(PacienteEntity obj){
        id = obj.getId();
        nome = obj.getNome();
        telefone = obj.getTelefone();
        dataNascimento = obj.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
