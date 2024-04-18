package webapp.projeto_appescola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.NotasFaltas;
import java.util.List;


public interface NotasFaltasRepository extends CrudRepository<NotasFaltas, Long>{

    NotasFaltas findByIdAluno(Long idAluno);
}
