package br.com.sistema.hospitalar.entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private String dataNascimento;

    @OneToMany(mappedBy = "paciente")
    private List<InternacaoEntity> internacao1 = new ArrayList<>();

    public PacienteEntity(){

    }

    public PacienteEntity(Long id, String nome, String telefone, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
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

    public List<InternacaoEntity> getInternacao1() {
        return internacao1;
    }

    public void setInternacao1(List<InternacaoEntity> internacao1) {
        this.internacao1 = internacao1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PacienteEntity)) return false;
        PacienteEntity that = (PacienteEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getInternacao1(), that.getInternacao1());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
