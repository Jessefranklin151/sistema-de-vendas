package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Endereco;
import sistemaDeVendas.repositorys.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco createEndereco(Endereco e) {
		
		return enderecoRepository.save(e);
		
	}

	public Endereco updateEndereco(Endereco e) {
		Endereco enderecoBase = readEndereco(e.getId());

		enderecoBase.setBairro(e.getBairro());
		enderecoBase.setCidade(e.getCidade());
		enderecoBase.setEstado(e.getEstado());
		enderecoBase.setNumero(e.getNumero());
		enderecoBase.setRua(e.getRua());

		return enderecoRepository.save(enderecoBase);
	}

	public Endereco readEndereco(String idEndereco) {
		return enderecoRepository.findById(idEndereco).get();
	}

	public ArrayList<Endereco> readAll() {
		return (ArrayList<Endereco>) enderecoRepository.findAll();
	}

	public Endereco removeEndereco(Endereco e) {
		enderecoRepository.deleteById(e.getId());
		return e;
	}

}
