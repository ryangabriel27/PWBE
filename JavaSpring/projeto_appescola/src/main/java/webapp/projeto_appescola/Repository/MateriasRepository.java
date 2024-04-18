package webapp.projeto_appescola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.Materias;
import java.util.List;


public interface MateriasRepository extends CrudRepository<Materias, Long>{

    Materias findByNomeMateria(String nomeMateria);
}
