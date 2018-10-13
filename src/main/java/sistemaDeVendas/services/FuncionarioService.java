package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Funcionario;
import sistemaDeVendas.repositorys.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario createFuncionario(Funcionario f) {
		
		return funcionarioRepository.save(f);
		
	}
	
	public Funcionario updateFuncionario(Funcionario f) {
		Funcionario funcionarioBase = readFuncionario(f.getId());
		
		funcionarioBase.setNome(f.getNome());
		funcionarioBase.setRegistro(f.getRegistro());
		funcionarioBase.setUsuario(f.getUsuario());
		
		return funcionarioRepository.save(funcionarioBase);
	}

	public Funcionario readFuncionario(String idFuncionario) {
		return funcionarioRepository.findById(idFuncionario).get();
	}
	
	public ArrayList<Funcionario> readAll() {
		return (ArrayList<Funcionario>) funcionarioRepository.findAll();
	}
	
	public Funcionario removeFuncionario(Funcionario f) {
		funcionarioRepository.delete(f);
		return f;
	}
	
}
