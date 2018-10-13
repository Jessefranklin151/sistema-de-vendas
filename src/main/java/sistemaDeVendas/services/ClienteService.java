package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Cliente;
import sistemaDeVendas.repositorys.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente createCliente(Cliente c) {
		
		return clienteRepository.save(c);
		
	}
	
	public Cliente updateCliente(Cliente c) {
		Cliente clienteBase = readCliente(c.getId());
	
		clienteBase.setEndereco(c.getEndereco());
		clienteBase.setNome(c.getNome());
		clienteBase.setTelefone(c.getTelefone());

		return clienteRepository.save(clienteBase);
	}

	public Cliente readCliente(String idCliente) {
		return clienteRepository.findById(idCliente).get();
	}
	
	public ArrayList<Cliente> readAll() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente removeCliente(Cliente c) {
		clienteRepository.deleteById(c.getId());;
		return c;
	}
}
