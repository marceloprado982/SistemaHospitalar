package br.com.sistema.hospitalar.repositories;

import br.com.sistema.hospitalar.entities.InternacaoEntity;
import br.com.sistema.hospitalar.entities.ProfissionalSaudeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InternacaoRepository extends JpaRepository<InternacaoEntity, Long> {

//    /*contagem do numero de internações de cada paciente */
//    select nome_paciente,
//    count(nome_paciente) as quantidade_internacao
//    from internacao_entity
//    group by nome_paciente
//    order by quantidade_internacao desc;

    @Query(value = "select nome_paciente,\n" +
            "count(nome_paciente) as quantidade_internacao\n" +
            "from internacao_entity\n" +
            "group by nome_paciente\n" +
            "order by quantidade_internacao desc;", nativeQuery = true)
    List<InternacaoEntity> findByNumberHospitalizationByPatient();
}
