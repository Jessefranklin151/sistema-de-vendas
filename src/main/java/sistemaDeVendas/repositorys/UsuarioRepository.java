package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{

}
