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

	public Categoria createCategoria(Categoria c) {
		categoriaRepository.save(c);
		return c;
	}

	public Categoria updateCategoria(Categoria c) {
		Categoria categoriaBase = readCategoria(c.getId());

		categoriaBase.setNome(c.getNome());

		categoriaRepository.save(categoriaBase);
		return categoriaBase;
	}

	public Categoria readCategoria(String idCategoria) {
		return categoriaRepository.findById(idCategoria).get();
	}

	public ArrayList<Categoria> readAll() {
		return (ArrayList<Categoria>) categoriaRepository.findAll();
	}

	public Categoria removeCategoria(Categoria c) {
		categoriaRepository.deleteById(c.getId());
		return c;
	}
}
