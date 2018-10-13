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

	public void createFuncionario(Funcionario f) {
		funcionarioRepository.save(f);
	}
	
	public void updateFuncionario(Funcionario f) {
		Funcionario funcionarioBase = readFuncionario(f);
		
		funcionarioBase.setNome(f.getNome());
		funcionarioBase.setRegistro(f.getRegistro());
		funcionarioBase.setUsuario(f.getUsuario());
	}

	public Funcionario readFuncionario(Funcionario f) {
		return funcionarioRepository.findById(f.getId()).get();
	}
	
	public ArrayList<Funcionario> readAll() {
		return (ArrayList<Funcionario>) funcionarioRepository.findAll();
	}
	
	public void removeFuncionario(Funcionario f) {
		funcionarioRepository.delete(f);
	}
	
}
