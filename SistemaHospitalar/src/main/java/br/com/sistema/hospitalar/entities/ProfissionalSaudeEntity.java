package br.com.sistema.hospitalar.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ProfissionalSaudeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int matricula;

    private String nome;

    private String departamento;

    private String cargo;

    private String telefoneProfissional;

    @OneToMany(mappedBy = "profissional_saude")
    private List<InternacaoEntity> internacao2 = new ArrayList<>();

    private ProfissionalSaudeEntity(){

    }

    public ProfissionalSaudeEntity(Long id, int matricula, String nome, String departamento, String cargo, String telefoneProfissional) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
        this.cargo = cargo;
        this.telefoneProfissional = telefoneProfissional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<InternacaoEntity> getInternacao2() {
        return internacao2;
    }

    public void setInternacao2(List<InternacaoEntity> internacao2) {
        this.internacao2 = internacao2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfissionalSaudeEntity)) return false;
        ProfissionalSaudeEntity that = (ProfissionalSaudeEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
