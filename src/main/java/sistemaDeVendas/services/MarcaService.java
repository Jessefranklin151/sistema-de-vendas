package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Marca;
import sistemaDeVendas.repositorys.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public Marca createMarca(Marca m) {
		
		return marcaRepository.save(m);
		
	}

	public Marca updateMarca(Marca m) {
		Marca marcaBase = readMarca(m.getId());

		marcaBase.setFornecedor(m.getFornecedor());
		marcaBase.setNome(m.getNome());

		return marcaRepository.save(marcaBase);
		
	}

	public Marca readMarca(String idMarca) {
		return marcaRepository.findById(idMarca).get();
	}

	public ArrayList<Marca> readAll() {
		return (ArrayList<Marca>) marcaRepository.findAll();
	}

	public Marca removeMarca(Marca m) {
		marcaRepository.deleteById(m.getId());
		return m;
	}
}
