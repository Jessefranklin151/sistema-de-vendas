package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Cliente;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.RemocaoInvalidaException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente createCliente(Cliente c) {

		if (c == null || c.getId() != null) {
			throw new CriacaoInvalidaException("Cliente");
		}

		return clienteRepository.save(c);

	}

	public Cliente updateCliente(Cliente c) {

		if (c == null || c.getId() == null) {
			throw new UpdateInvalidoException("Cliente");
		}

		return clienteRepository.save(c);

	}

	public Cliente readCliente(String idCliente) {
		
		if (idCliente == null) {
			throw new IdInvalidoException("Cliente");
		}

		Optional<Cliente> c = clienteRepository.findById(idCliente);
		
		return c.orElseThrow(() -> NotFoundException.build("Cliente"));

//		if (!c.isPresent()) {
//			throw new NotFoundException("Cliente");
//		}

		//return c.get();

	}

	public ArrayList<Cliente> readAll() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}

	public Cliente removeCliente(Cliente c) {

		if (c == null || c.getId() == null) {
			throw new RemocaoInvalidaException("Cliente");
		}

		clienteRepository.deleteById(c.getId());

		return c;
	}
}
