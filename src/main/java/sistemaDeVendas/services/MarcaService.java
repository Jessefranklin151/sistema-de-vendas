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

	public void createMarca(Marca m) {
		marcaRepository.save(m);
	}

	public void updateMarca(Marca m) {
		Marca marcaBase = readMarca(m);

		marcaBase.setFornecedor(m.getFornecedor());
		marcaBase.setNome(m.getNome());

		marcaRepository.save(marcaBase);
	}

	public Marca readMarca(Marca m) {
		return marcaRepository.findById(m.getId()).get();
	}

	public ArrayList<Marca> readAll() {
		return (ArrayList<Marca>) marcaRepository.findAll();
	}

	public void removeMarca(Marca m) {
		marcaRepository.deleteById(m.getId());
	}
}
