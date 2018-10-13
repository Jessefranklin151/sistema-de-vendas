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

	public Usuario createUsuario(Usuario u) {
		
		return usuarioRepository.save(u);
		
	}

	public Usuario updateUsuario(Usuario u) {
		Usuario usuarioBase = readUsuario(u.getId());

		usuarioBase.setMatriculaFuncionario(u.getMatriculaFuncionario());
		usuarioBase.setSenha(u.getSenha());
		
		return usuarioRepository.save(usuarioBase);

	}

	public Usuario readUsuario(String idUsuario) {
		return usuarioRepository.findById(idUsuario).get();
	}
	
	public ArrayList<Usuario> readAll() {
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario removeUsuario(Usuario u) {
		usuarioRepository.deleteById(u.getId());
		return u;
	}
	
}
