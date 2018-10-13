package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, String>{

}
