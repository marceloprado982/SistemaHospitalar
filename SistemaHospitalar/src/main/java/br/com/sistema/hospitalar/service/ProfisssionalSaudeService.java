package br.com.sistema.hospitalar.service;

import br.com.sistema.hospitalar.dto.PacienteDTO;
import br.com.sistema.hospitalar.dto.ProfissionalSaudeDTO;
import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import br.com.sistema.hospitalar.repositories.ProfissionalSaudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfisssionalSaudeService {

    @Autowired
    private ProfissionalSaudeRepository profissionalSaudeRepository;

    public ProfissionalSaudeEntity findById(Long id){
        Optional<ProfissionalSaudeEntity> paciente = profissionalSaudeRepository.findById(id);
       return paciente.orElseThrow(() -> new RuntimeException() );
    }


    public List<ProfissionalSaudeEntity> findAll() {
        return profissionalSaudeRepository.findAll();
    }

    public List<ProfissionalSaudeEntity> findByNumberMedicByDepartament() {
        return profissionalSaudeRepository.findByNumberMedicByDepartament();
    }


    public ProfissionalSaudeEntity insert(ProfissionalSaudeEntity obj) {
        obj.setId(null);
        obj = profissionalSaudeRepository.save(obj);
        return obj;
    }

    public ProfissionalSaudeEntity update(ProfissionalSaudeEntity obj) {
        findById(obj.getId());
        return profissionalSaudeRepository.save(obj);
    }

    public void delete(Long id){
        findById(id);
        try {
            profissionalSaudeRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            try {
                throw new DateIntegrityException("Não é possível excluir uma Paciente ");
            } catch (DateIntegrityException ex) {
                ex.printStackTrace();
            }

        }
    }

    public ProfissionalSaudeEntity fromDto(ProfissionalSaudeDTO obj){
        return  new ProfissionalSaudeEntity(obj.getId(), obj.getMatricula(),obj.getNome(),obj.getDepartamento(),obj.getCargo(),obj.getTelefoneProfissional());
    }

}
