package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, String>{

}
