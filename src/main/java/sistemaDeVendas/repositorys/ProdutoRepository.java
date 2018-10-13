package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, String> {

}
