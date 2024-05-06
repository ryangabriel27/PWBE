package webapp.projeto_appescola.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long>{
    
    List<Aluno> findByMateria1(String materia1);

    boolean existsByEmail(String email);

    boolean existsByUsuario(String usuario);

    Aluno findByEmail(String email);

    Aluno findByUsuario(String usuario);
}
