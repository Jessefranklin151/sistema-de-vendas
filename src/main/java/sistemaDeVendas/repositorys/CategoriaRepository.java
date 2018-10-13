package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, String>{

}
