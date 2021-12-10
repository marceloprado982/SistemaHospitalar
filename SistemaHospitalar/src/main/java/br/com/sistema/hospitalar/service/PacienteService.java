package br.com.sistema.hospitalar.service;

import br.com.sistema.hospitalar.dto.PacienteDTO;
import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteEntity findById(Long id) {
        Optional<PacienteEntity> paciente = pacienteRepository.findById(id);
        return paciente.orElseThrow(() -> new RuntimeException());
    }

    public List<PacienteEntity> findAll() {
        return pacienteRepository.findAll();
    }


    public PacienteEntity insert(PacienteEntity obj) {
        obj.setId(null);
        obj = pacienteRepository.save(obj);
        return obj;
    }

    public PacienteEntity update(PacienteEntity obj) {
        findById(obj.getId());
        return pacienteRepository.save(obj);
    }

    public void delete(Long id){
        findById(id);
        try {
            pacienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            try {
                throw new DateIntegrityException("Não é possível excluir uma Paciente ");
            } catch (DateIntegrityException ex) {
                ex.printStackTrace();
            }

        }
    }

    public PacienteEntity fromDto(PacienteDTO obj){
        return  new PacienteEntity(obj.getId(), obj.getNome(),obj.getTelefone(),obj.getDataNascimento());
    }
}