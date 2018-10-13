package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Categoria;
import sistemaDeVendas.repositorys.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public void createCategoria(Categoria c) {
		categoriaRepository.save(c);
	}

	public void updateCategoria(Categoria c) {
		Categoria categoriaBase = readCategoria(c);

		categoriaBase.setNome(c.getNome());

		categoriaRepository.save(categoriaBase);
	}

	public Categoria readCategoria(Categoria c) {
		return categoriaRepository.findById(c.getId()).get();
	}

	public ArrayList<Categoria> readAll() {
		return (ArrayList<Categoria>) categoriaRepository.findAll();
	}

	public void removeCategoria(Categoria c) {
		categoriaRepository.deleteById(c.getId());
	}
}
