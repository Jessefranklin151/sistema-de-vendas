package sistemaDeVendas.repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sistemaDeVendas.domains.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, String>{

}
