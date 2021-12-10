package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.dto.PacienteDTO;
import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/pacientes")
public class PacienteController {

    private final List<PacienteEntity> pacientes = new ArrayList<>();


    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() {
       List<PacienteEntity> lista = pacienteService.findAll();
       List<PacienteDTO> listDto = lista.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PacienteDTO> findyById(@PathVariable("id") Long id){
        PacienteEntity paciente = pacienteService.findById(id);
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);
        return  ResponseEntity.ok().body(pacienteDTO);
    }



    @PostMapping
    public ResponseEntity<PacienteEntity> insert(@RequestBody PacienteDTO pacienteDTO){
        PacienteEntity paciente = pacienteService.fromDto(pacienteDTO);
        paciente = pacienteService.insert(paciente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }



    @PutMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody PacienteDTO pacienteDTO, @PathVariable Long id){
        PacienteEntity paciente = pacienteService.fromDto(pacienteDTO);
        paciente.setId(id);
        paciente = pacienteService.update(paciente);
        return ResponseEntity.noContent().build();
    }
//


    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteEntity> delete(@PathVariable("id") final Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }


}

