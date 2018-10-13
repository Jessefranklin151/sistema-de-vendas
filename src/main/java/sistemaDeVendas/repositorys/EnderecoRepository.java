package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{

}
