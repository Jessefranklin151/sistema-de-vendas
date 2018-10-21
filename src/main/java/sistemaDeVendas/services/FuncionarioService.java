package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Funcionario;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.RemocaoInvalidaException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario createFuncionario(Funcionario f) {
		
		if(f == null || f.getId() == null) {
			throw new CriacaoInvalidaException("Funcionario");
		}

		return funcionarioRepository.save(f);
		
	}
	
	public Funcionario updateFuncionario(Funcionario f) {
		
		if (f == null || f.getId() == null) {
			throw new UpdateInvalidoException("Funcionario Invalido");
		}
		
		return funcionarioRepository.save(f);
		
	}

	public Funcionario readFuncionario(String idFuncionario) {
		
		if(idFuncionario == null) {
			throw new IdInvalidoException("Id Funcionario");
		}
		
		Optional<Funcionario> f = funcionarioRepository.findById(idFuncionario);
		
//		if (f.isPresent()) {
//			throw new NotFoundException("Funcionario");
//		}
		
		
		return f.orElseThrow(() -> NotFoundException.build("Funcionario"));
		
		//return funcionarioRepository.findById(idFuncionario).get();
	}
	
	public ArrayList<Funcionario> readAll() {
		return (ArrayList<Funcionario>) funcionarioRepository.findAll();
	}
	
	public Funcionario removeFuncionario(Funcionario f) {
		
		if (f == null || f.getId() == null) {
			throw new RemocaoInvalidaException("Funcionario");
		}
		
		funcionarioRepository.delete(f);
		return f;
	}
	
}
