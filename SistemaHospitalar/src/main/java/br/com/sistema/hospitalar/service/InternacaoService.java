package br.com.sistema.hospitalar.service;

import br.com.sistema.hospitalar.dto.InternacaoDTO;
import br.com.sistema.hospitalar.dto.PacienteDTO;
import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.repositories.InternacaoRepository;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternacaoService {

    @Autowired
    private InternacaoRepository internacaoRepository;

    public InternacaoEntity findById(Long id){
        Optional<InternacaoEntity> paciente = internacaoRepository.findById(id);
       return paciente.orElseThrow(() -> new RuntimeException() );
    }


    public List<InternacaoEntity> findAll() {
        return internacaoRepository.findAll();
    }

    public List<InternacaoEntity> findByNumberMedicByDepartament() {
        return internacaoRepository.findByNumberHospitalizationByPatient();
    }

    public InternacaoEntity insert(InternacaoEntity obj) {
        obj.setInternacaoPaciente(null);
        obj = internacaoRepository.save(obj);
        return obj;
    }

    public InternacaoEntity update(InternacaoEntity obj) {
        findById(obj.getInternacaoPaciente());
        return internacaoRepository.save(obj);
    }

    public void delete(Long id){
        findById(id);
        try {
            internacaoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            try {
                throw new DateIntegrityException("Não é possível excluir uma Paciente ");
            } catch (DateIntegrityException ex) {
                ex.printStackTrace();
            }

        }
    }

    public InternacaoEntity fromDto(InternacaoDTO obj){
        return  new InternacaoEntity(obj.getInternacaoPaciente(), obj.getNomePaciente(), obj.getDataHoraEntrada(),obj.getDataHoraSaida(),obj.getDiagnostico(), obj.getIdProfissional(), obj.getIdPaciente());
    }
}
