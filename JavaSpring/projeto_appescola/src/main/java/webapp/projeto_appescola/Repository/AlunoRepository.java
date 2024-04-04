package webapp.projeto_appescola.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, String>{
    
}
