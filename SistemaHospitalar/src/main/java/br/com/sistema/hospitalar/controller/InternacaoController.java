package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.dto.InternacaoDTO;
import br.com.sistema.hospitalar.dto.PacienteDTO;
import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import br.com.sistema.hospitalar.repositories.InternacaoRepository;
import br.com.sistema.hospitalar.service.InternacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/internacoes")
public class InternacaoController {

    @Autowired
    private InternacaoService internacaoService;

    @GetMapping
    public ResponseEntity<List<InternacaoEntity>> findAll() {
        List<InternacaoEntity> lista = internacaoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/contagem")
    public ResponseEntity<List<InternacaoEntity>> findByNumberMedicByDepartament() {
        List<InternacaoEntity> lista = internacaoService.findByNumberMedicByDepartament();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InternacaoEntity> findyById(@PathVariable("id") Long id){
        InternacaoEntity paciente = internacaoService.findById(id);
        return  ResponseEntity.ok().body(paciente);
    }



    @PostMapping
    public ResponseEntity<InternacaoEntity> insert(@RequestBody InternacaoDTO internacaoDTO){
        InternacaoEntity internacao = internacaoService.fromDto(internacaoDTO);
        internacao = internacaoService.insert(internacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(internacao.getInternacaoPaciente()).toUri();
        return ResponseEntity.created(uri).build();
    }



    @PutMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody InternacaoDTO internacaoDTO, @PathVariable Long id){
        InternacaoEntity internacao = internacaoService.fromDto(internacaoDTO);
        internacao.setInternacaoPaciente(id);
        internacao = internacaoService.update(internacao);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteEntity> delete(@PathVariable("id") final Long id){
        internacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
