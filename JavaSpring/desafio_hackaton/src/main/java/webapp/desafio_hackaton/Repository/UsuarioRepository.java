package webapp.desafio_hackaton.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.desafio_hackaton.Model.Usuario;
import java.util.List;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    boolean existsByEmail(String email);

    Usuario findByEmail(String email);

    Usuario findById(int id);
}
