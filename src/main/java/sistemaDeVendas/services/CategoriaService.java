package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Categoria;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.RemocaoInvalidaException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria createCategoria(Categoria c) {

		if (c == null || c.getId() != null) {
			throw new CriacaoInvalidaException("Categoria");
		}

		return categoriaRepository.save(c);

	}

	public Categoria updateCategoria(Categoria c)  {

		if (c == null || c.getId() == null) {
			throw new UpdateInvalidoException("Categoria");
		}

		return categoriaRepository.save(c);
		
	}

	public Categoria readCategoria(String idCategoria)  {
		
		if (idCategoria == null) {
			throw new IdInvalidoException("Categoria");
		}

		Optional<Categoria> c = categoriaRepository.findById(idCategoria);

//		if (!c.isPresent()) {
//			throw new NotFoundException("Categoria não encontrada.");
//		}
		
		return c.orElseThrow(() -> (NotFoundException.build("Categoria não encontrada.")));

		// return c.get();
	}

	public ArrayList<Categoria> readAll() {
		return (ArrayList<Categoria>) categoriaRepository.findAll();
	}

	public Categoria removeCategoria(Categoria c) {

		if (c == null || c.getId() == null) {
			throw new RemocaoInvalidaException("Categoria");
		}

		categoriaRepository.deleteById(c.getId());
		return c;
	}
}
