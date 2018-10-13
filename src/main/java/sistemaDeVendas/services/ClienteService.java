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
	
	public void createCliente(Cliente c) {
		clienteRepository.save(c);
	}
	
	public void updateCliente(Cliente c) {
		Cliente clienteBase = readCliente(c);
	
		clienteBase.setEndereco(c.getEndereco());
		clienteBase.setNome(c.getNome());
		clienteBase.setTelefone(c.getTelefone());

		clienteRepository.save(clienteBase);
	}

	public Cliente readCliente(Cliente c) {
		return clienteRepository.findById(c.getId()).get();
	}
	
	public ArrayList<Cliente> readAll() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}
	
	public void removeCliente(Cliente c) {
		clienteRepository.deleteById(c.getId());;
	}
}
