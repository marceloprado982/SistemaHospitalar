package br.com.sistema.hospitalar.dto;

import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.PacienteEntity;

public class InternacaoDTO {

    private Long internacaoPaciente;
    private String nomePaciente;
    private String dataHoraEntrada;
    private String dataHoraSaida;
    private String diagnostico;
    private Long idProfissional;
    private Long idPaciente;


    public InternacaoDTO(){

    }

    public InternacaoDTO(InternacaoEntity obj){
        internacaoPaciente = obj.getInternacaoPaciente();
        nomePaciente = obj.getNomePaciente();
        dataHoraEntrada = obj.getDataHoraEntrada();
        dataHoraSaida = obj.getDataHoraSaida();
        diagnostico = obj.getDiagnostico();
    }

    public Long getInternacaoPaciente() {
        return internacaoPaciente;
    }

    public void setInternacaoPaciente(Long internacaoPaciente) {
        this.internacaoPaciente = internacaoPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(String dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(String dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Long getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Long idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
