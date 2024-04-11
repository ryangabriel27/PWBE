package webapp.projeto_appescola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.Professor;

public interface ProfessoresRepository extends CrudRepository<Professor, String>{
    
}
