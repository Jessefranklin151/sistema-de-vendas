package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Usuario;
import sistemaDeVendas.repositorys.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void createUsuario(Usuario u) {
		usuarioRepository.save(u);
	}

	public void updateUsuario(Usuario u) {
		Usuario usuarioBase = readUsuario(u);

		usuarioBase.setMatriculaFuncionario(u.getMatriculaFuncionario());
		usuarioBase.setSenha(u.getSenha());
		usuarioRepository.save(usuarioBase);

	}

	public Usuario readUsuario(Usuario u) {
		return usuarioRepository.findById(u.getId()).get();
	}
	
	public ArrayList<Usuario> readAll() {
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}
	
	public void removeUsurio(Usuario u) {
		usuarioRepository.deleteById(u.getId());
	}
	
}
