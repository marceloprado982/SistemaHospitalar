package br.com.sistema.hospitalar.dto;

import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;

public class ProfissionalSaudeDTO {

    private long id;
    private int matricula;
    private String nome;
    private String departamento;
    private String cargo;
    private String telefoneProfissional;

    public ProfissionalSaudeDTO() {

    }

    public ProfissionalSaudeDTO(ProfissionalSaudeEntity obj) {
        id = obj.getId();
        matricula = obj.getMatricula();
        nome = obj.getNome();
        departamento = obj.getDepartamento();
        cargo = obj.getCargo();
        telefoneProfissional = obj.getTelefoneProfissional();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefoneProfissional() {
        return telefoneProfissional;
    }

    public void setTelefoneProfissional(String telefoneProfissional) {
        this.telefoneProfissional = telefoneProfissional;
    }
}
