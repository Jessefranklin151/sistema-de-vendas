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

	public void createVenda(Venda v) {
		vendaRepository.save(v);
	}

	public void updateVenda(Venda v) {
		Venda vendaBase = readVenda(v);

		vendaBase.setCliente(v.getCliente());
		vendaBase.setFuncionario(v.getFuncionario());
		vendaBase.setPedidos(v.getPedidos());
		vendaBase.setValorTotal(v.getValorTotal());

		vendaRepository.save(vendaBase);
	}

	public Venda readVenda(Venda v) {
		return vendaRepository.findById(v.getId()).get();
	}

	public ArrayList<Venda> readAll() {
		return (ArrayList<Venda>) vendaRepository.findAll();
	}

	public void removeVenda(Venda v) {
		vendaRepository.deleteById(v.getId());
	}

}
