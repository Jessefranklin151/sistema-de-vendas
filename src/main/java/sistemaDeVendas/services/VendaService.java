package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Venda;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	public Venda createVenda(Venda v)  {
		
		if (v == null) {
			throw new CriacaoInvalidaException("Venda");
		}
		
		return vendaRepository.save(v);
		
	}

	public Venda updateVenda(Venda v) {
		
		if (v == null || v.getId() == null ) {
			throw new UpdateInvalidoException("Venda");
		}

		return vendaRepository.save(v);
	}

	public Venda readVenda(String idVenda) {
		
		if (idVenda == null) {
			throw new IdInvalidoException("Venda");
		}
		
		Optional<Venda> v = vendaRepository.findById(idVenda);
		
		return v.orElseThrow(() -> (NotFoundException.build("Venda não encontrada."))); // conferir se ta certo.
		
		
//		if (!v.isPresent()) {
//			throw new VendaNaoEncontradaException();
//		}
//		
//		return v.get();
	}


	public ArrayList<Venda> readAll() {
		return (ArrayList<Venda>) vendaRepository.findAll();
	}

	public Venda removeVenda(Venda v) {
		if(v == null || v.getId() == null) {
			
		}
		
		
		vendaRepository.deleteById(v.getId());
		return v;
	}

}
