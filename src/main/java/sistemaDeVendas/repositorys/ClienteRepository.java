package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{

}
