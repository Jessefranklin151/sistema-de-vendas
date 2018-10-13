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

	public Fornecedor createFornecedor(Fornecedor f) {

		return fornecedorRepository.save(f);

	}

	public Fornecedor updateFornecedor(Fornecedor f) {
		Fornecedor fornecedorBase = readFornecedor(f.getId());

		fornecedorBase.setCnpj(f.getCnpj());
		fornecedorBase.setDataDeContrato(f.getDataDeContrato());
		fornecedorBase.setEmail(f.getEmail());
		fornecedorBase.setNome(f.getNome());
		fornecedorBase.setTelefone(f.getTelefone());

		return fornecedorRepository.save(fornecedorBase);
	}

	public Fornecedor readFornecedor(String idFornecedor) {
		return fornecedorRepository.findById(idFornecedor).get();
	}

	public ArrayList<Fornecedor> readAll() {
		return (ArrayList<Fornecedor>) fornecedorRepository.findAll();
	}

	public Fornecedor removeFornecedor(Fornecedor f) {
		fornecedorRepository.deleteById(f.getId());
		return f;
	}
}
