package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.dto.ProfissionalSaudeDTO;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.repositories.ProfissionalSaudeRepository;
import br.com.sistema.hospitalar.service.ProfisssionalSaudeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/profissionalSaude")
public class ProfissionalSaudeController {

    @Autowired
    private ProfisssionalSaudeService profisssionalSaudeService;

    @GetMapping("/contagem")
    public ResponseEntity<List<ProfissionalSaudeEntity>> findByNumberMedicByDepartament() {
        List<ProfissionalSaudeEntity> lista = profisssionalSaudeService.findByNumberMedicByDepartament();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalSaudeDTO>> findAll() {
        List<ProfissionalSaudeEntity> lista = profisssionalSaudeService.findAll();
        List<ProfissionalSaudeDTO> listDto = lista.stream().map(obj -> new ProfissionalSaudeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProfissionalSaudeDTO> findyById(@PathVariable("id") Long id){
        ProfissionalSaudeEntity profissionalSaude = profisssionalSaudeService.findById(id);
        ProfissionalSaudeDTO profissionalSaudeDTO = new ProfissionalSaudeDTO(profissionalSaude);
        return  ResponseEntity.ok().body(profissionalSaudeDTO);
    }



    @RolesAllowed("admin")
    @PostMapping
    public ResponseEntity<ProfissionalSaudeEntity> insert(@RequestBody ProfissionalSaudeDTO profissionalSaudeDTO){
        ProfissionalSaudeEntity profissionalSaude = profisssionalSaudeService.fromDto(profissionalSaudeDTO);
        profissionalSaude = profisssionalSaudeService.insert(profissionalSaude);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(profissionalSaude.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @RolesAllowed("admin")
    @PutMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ProfissionalSaudeDTO profissionalSaudeDTO, @PathVariable Long id){
        ProfissionalSaudeEntity profissionalSaude = profisssionalSaudeService.fromDto(profissionalSaudeDTO);
        profissionalSaude.setId(id);
        profissionalSaude = profisssionalSaudeService.update(profissionalSaude);
        return ResponseEntity.noContent().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<ProfissionalSaudeEntity> delete(@PathVariable("id") final Long id){
        profisssionalSaudeService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
