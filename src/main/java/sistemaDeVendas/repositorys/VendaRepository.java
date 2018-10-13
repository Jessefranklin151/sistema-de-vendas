package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Venda;

@Repository
public interface VendaRepository extends CrudRepository<Venda, String> {

}
