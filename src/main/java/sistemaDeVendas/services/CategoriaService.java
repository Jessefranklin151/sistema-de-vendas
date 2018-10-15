package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Categoria;
import sistemaDeVendas.exceptions.CategoriaInvalidaException;
import sistemaDeVendas.exceptions.CategoriaNaoEncontradaException;
import sistemaDeVendas.exceptions.NovaCategoriaInvalidaException;
import sistemaDeVendas.repositorys.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria createCategoria(Categoria c) throws CategoriaInvalidaException {
		
		if (c.getId() != null && c.getNome() != null) {
			return categoriaRepository.save(c);
		}
		
		throw new CategoriaInvalidaException();
		
		
	}

	public Categoria updateCategoria(Categoria c) throws NovaCategoriaInvalidaException, CategoriaNaoEncontradaException {
		
		if (!(c.getId() != null && c.getNome() != null)) {
			throw new NovaCategoriaInvalidaException();
		}
		
		Categoria categoriaBase = readCategoria(c.getId());

		categoriaBase.setNome(c.getNome());

		return categoriaRepository.save(categoriaBase);
	}

	public Categoria readCategoria(String idCategoria) throws CategoriaNaoEncontradaException {
		if (!categoriaRepository.findById(idCategoria).isPresent()) {
			throw new CategoriaNaoEncontradaException();
		}
		
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
