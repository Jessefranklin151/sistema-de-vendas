package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Endereco;
import sistemaDeVendas.repositorys.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public void createEndereco(Endereco e) {
		enderecoRepository.save(e);
	}
	
	public void updateEndereco(Endereco e) {
		Endereco enderecoBase = readEndereco(e);
		
		enderecoBase.setBairro(e.getBairro());
		enderecoBase.setCidade(e.getCidade());
		enderecoBase.setEstado(e.getEstado());
		enderecoBase.setNumero(e.getNumero());
		enderecoBase.setRua(e.getRua());
		
		enderecoRepository.save(enderecoBase);
	}

	public Endereco readEndereco(Endereco e) {
		return enderecoRepository.findById(e.getId()).get();
	}
	
	public ArrayList<Endereco> readAll() {
		return (ArrayList<Endereco>) enderecoRepository.findAll();
	}
	
	public void removeEndereco(Endereco e) {
		enderecoRepository.deleteById(e.getId());
	}
	
	
 }
