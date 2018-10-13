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

import sistemaDeVendas.domains.Endereco;
import sistemaDeVendas.services.EnderecoService;

@Controller
@RequestMapping(value = "/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<Endereco> createEndereco(Endereco endereco) {

		Endereco en = null;

		try {
			en = enderecoService.createEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Endereco>(en, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Endereco>(en, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Endereco> updateEndereco(Endereco endereco) {

		Endereco en = null;

		try {
			en = enderecoService.updateEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Endereco>(en, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Endereco>(en, HttpStatus.OK);

	}

	@GetMapping("/endereco/id")
	public ResponseEntity<Endereco> readEndereco(@PathParam("id") String idEndereco) {

		Endereco en = null;

		try {
			en = enderecoService.readEndereco(idEndereco);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Endereco>(en, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Endereco>(en, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Endereco>> readEndereco() {

		ArrayList<Endereco> enderecos = null;

		try {
			enderecos = enderecoService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Endereco>>(enderecos, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Endereco>>(enderecos, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Endereco> deleteEndereco(Endereco endereco) {

		Endereco en = null;

		try {
			en = enderecoService.removeEndereco(endereco);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Endereco>(en, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Endereco>(en, HttpStatus.OK);

	}

}
