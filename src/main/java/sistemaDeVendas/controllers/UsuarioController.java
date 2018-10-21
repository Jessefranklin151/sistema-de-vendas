package sistemaDeVendas.controllers;

import java.util.ArrayList;

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

		return new ResponseEntity<Usuario>(usuarioService.createUsuario(usuario), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Usuario> updateUsuario(Usuario usuario) {

		return new ResponseEntity<Usuario>(usuarioService.updateUsuario(usuario), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> readUsuario(@PathParam("id") String idUsuario) {

		return new ResponseEntity<Usuario>(usuarioService.readUsuario(idUsuario), HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Usuario> deleteUsuario(Usuario usuario) {

		return new ResponseEntity<Usuario>(usuarioService.removeUsuario(usuario), HttpStatus.OK);

	}
	
	@GetMapping
	public ResponseEntity<ArrayList<Usuario>> readAll() {
		
		ArrayList<Usuario> usuarios = null;
		
		try {
			usuarios = usuarioService.readAll();
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Usuario>>(usuarios, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ArrayList<Usuario>>(usuarios, HttpStatus.OK);
		
	}
	

}
