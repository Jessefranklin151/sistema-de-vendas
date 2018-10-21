package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Usuario;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.RemocaoInvalidaException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario createUsuario(Usuario u) {

		if (u == null || u.getId() != null) {
			throw new CriacaoInvalidaException("Usuário");
		}

		return usuarioRepository.save(u);

	}

	public Usuario updateUsuario(Usuario u) {

		if (u == null || u.getId() == null) {
			throw new UpdateInvalidoException("Usuário");
		}

		return usuarioRepository.save(u);

	}

	public Usuario readUsuario(String idUsuario) {

		if (idUsuario == null) {
			throw new IdInvalidoException("Id Usuário");
		}

		Optional<Usuario> u = usuarioRepository.findById(idUsuario);

		return u.orElseThrow(() -> NotFoundException.build("Usuário"));

//		if (!u.isPresent()) {
//			throw new NotFoundException("Usuário");
//		}

//		return u.get();
	}

	public ArrayList<Usuario> readAll() {
		return (ArrayList<Usuario>) usuarioRepository.findAll();
	}

	public Usuario removeUsuario(Usuario u) {

		if (u == null || u.getId() == null) {
			throw new RemocaoInvalidaException("Usuário");
		}

		usuarioRepository.deleteById(u.getId());
		return u;
	}

}
