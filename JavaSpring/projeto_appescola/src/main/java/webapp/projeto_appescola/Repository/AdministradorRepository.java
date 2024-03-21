package webapp.projeto_appescola.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.AdministradorModel;

public interface AdministradorRepository extends CrudRepository<AdministradorModel, Long>{

    // Método para buscar administradores por CPF
    AdministradorModel findByCpf(String cpf);

    // Método para buscar administradores por email
    AdministradorModel findByEmail(String email);

    // Busca para vários nomes Funcionários
    @Query(value = "select u from AdministradorModel u where u.nome like %?1%")
    List<AdministradorModel> findByNomes(String nome);
}
