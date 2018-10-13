package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Venda;
import sistemaDeVendas.repositorys.VendaRepository;

@Service
public class VendaService {

	@Autowired
	public VendaRepository vendaRepository;

	public Venda createVenda(Venda v) {
		vendaRepository.save(v);
		return v;
	}

	public Venda updateVenda(Venda v) {
		Venda vendaBase = readVenda(v.getId());

		vendaBase.setCliente(v.getCliente());
		vendaBase.setFuncionario(v.getFuncionario());
		vendaBase.setPedidos(v.getPedidos());
		vendaBase.setValorTotal(v.getValorTotal());

		vendaRepository.save(vendaBase);
		return vendaBase;
	}

	public Venda readVenda(String idVenda) {
		return vendaRepository.findById(idVenda).get();
	}

	public ArrayList<Venda> readAll() {
		return (ArrayList<Venda>) vendaRepository.findAll();
	}

	public Venda removeVenda(Venda v) {
		vendaRepository.deleteById(v.getId());
		return v;
	}

}
