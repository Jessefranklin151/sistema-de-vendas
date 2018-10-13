package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{

}
