package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Pedido;
import sistemaDeVendas.repositorys.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido creatPedido(Pedido p) {
		
		return pedidoRepository.save(p);

	}

	public Pedido updatePedido(Pedido p) {
		Pedido pedidoBase = readPedido(p.getId());

		pedidoBase.setProduto(p.getProduto());
		pedidoBase.setQuantidade(p.getQuantidade());
		pedidoBase.setValorTotalPedido(p.getValorTotalPedido());

		return pedidoRepository.save(pedidoBase);

	}

	public Pedido readPedido(String idPedido) {
		return pedidoRepository.findById(idPedido).get();
	}

	public ArrayList<Pedido> readAll() {
		return (ArrayList<Pedido>) pedidoRepository.findAll();
	}

	public Pedido removePedido(Pedido p) {
		pedidoRepository.deleteById(p.getId());
		return p;
	}
}
