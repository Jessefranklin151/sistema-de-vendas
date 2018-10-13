package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Fornecedor;
import sistemaDeVendas.repositorys.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	public void createFornecedor(Fornecedor f) {
		fornecedorRepository.save(f);
	}
	
	public void updateFornecedor(Fornecedor f) {
		Fornecedor fornecedorBase = readFornecedor(f);

		fornecedorBase.setCnpj(f.getCnpj());
		fornecedorBase.setDataDeContrato(f.getDataDeContrato());
		fornecedorBase.setEmail(f.getEmail());
		fornecedorBase.setNome(f.getNome());
		fornecedorBase.setTelefone(f.getTelefone());
		
		fornecedorRepository.save(fornecedorBase);
	}

	public Fornecedor readFornecedor(Fornecedor f) {
		return fornecedorRepository.findById(f.getId()).get();
	}
	
	public ArrayList<Fornecedor> readAll() {
		return (ArrayList<Fornecedor>) fornecedorRepository.findAll();
	}
	
	public void removeFornecedor(Fornecedor f) {
		fornecedorRepository.deleteById(f.getId());
	}
}
