package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Marca;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.RemocaoInvalidaException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.MarcaRepository;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;

	public Marca createMarca(Marca m) {

		if (m == null) {
			throw new CriacaoInvalidaException("Marca");
		}

		return marcaRepository.save(m);

	}

	public Marca updateMarca(Marca m) {

		if (m == null || m.getId() != null) {
			throw new UpdateInvalidoException("Marca");
		}

		return marcaRepository.save(m);

	}

	public Marca readMarca(String idMarca) {
		
		if (idMarca == null) {
			throw new IdInvalidoException("Marca");
		}

		Optional<Marca> m = marcaRepository.findById(idMarca);

		m.orElseThrow(() -> (NotFoundException.build("Marca não encontrada.")));

//		if(!m.isPresent()) {
//			throw new MarcaNaoEncontradaException();
//		}

		return m.get();
	}

	public ArrayList<Marca> readAll() {
		return (ArrayList<Marca>) marcaRepository.findAll();
	}

	public Marca removeMarca(Marca m) {
		
		if(m == null || m.getId() == null) {
			throw new RemocaoInvalidaException("Marca");
		}
		
		marcaRepository.deleteById(m.getId());
		return m;
	}
}
