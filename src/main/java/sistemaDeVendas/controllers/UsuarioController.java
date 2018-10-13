package sistemaDeVendas.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sistemaDeVendas.domains.Usuario;
import sistemaDeVendas.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<Usuario> createUsuario(Usuario usuario) {

		Usuario u = null;

		try {
			u = usuarioService.createUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(u, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(Usuario usuario) {

		Usuario u = null;

		try {
			u = usuarioService.updateUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(u, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> readUsuario(@PathParam("id") String idUsuario) {

		Usuario u = null;

		try {
			u = usuarioService.readUsuario(idUsuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(u, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Usuario> readUsuario(Usuario usuario) {

		Usuario u = null;

		try {
			u = usuarioService.removeUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(u, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}

}
