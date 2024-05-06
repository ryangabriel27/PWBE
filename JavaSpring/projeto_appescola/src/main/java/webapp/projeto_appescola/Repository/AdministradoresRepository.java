package webapp.projeto_appescola.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webapp.projeto_appescola.Model.Administradores;

public interface AdministradoresRepository extends CrudRepository<Administradores, String>{   

    //Se eu precisar criar algum método extra eu vou criar AQUI

    // Método para buscar administradores por CPF
    Administradores findByCpf(String cpf);

    // Método para buscar administradores por email
    Administradores findByEmail(String email);

    // Busca para vários nomes Funcionários
    @Query(value = "select u from Administradores u where u.nome like %?1%")
    List<Administradores> findByNomes(String nome);
}
