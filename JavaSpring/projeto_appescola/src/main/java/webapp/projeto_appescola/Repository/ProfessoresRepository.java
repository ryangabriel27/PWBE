package webapp.projeto_appescola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.Professor;
import java.util.List;

public interface ProfessoresRepository extends CrudRepository<Professor, String> {

    // Procura professor pelo cpf
    Professor findByCpf(String cpf);

    Professor findByUsuario(String usuario);

    List<Professor> findAllByMateria(
            String materia);
}
