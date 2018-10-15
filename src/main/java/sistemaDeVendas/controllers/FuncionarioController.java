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

import sistemaDeVendas.domains.Funcionario;
import sistemaDeVendas.services.FuncionarioService;

@Controller
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	private ResponseEntity<Funcionario> createFuncionario(Funcionario funcionario) {

		Funcionario f = null;

		try {
			f = funcionarioService.createFuncionario(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Funcionario>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Funcionario>(f, HttpStatus.OK);

	}

	@PutMapping
	private ResponseEntity<Funcionario> updateFuncionario(Funcionario funcionario) {

		Funcionario f = null;

		try {
			f = funcionarioService.updateFuncionario(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Funcionario>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Funcionario>(f, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> readFornecedor(@PathParam("id") String idFuncionario) {

		Funcionario f = null;

		try {
			f = funcionarioService.readFuncionario(idFuncionario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Funcionario>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Funcionario>(f, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Funcionario>> readAll() {

		ArrayList<Funcionario> funcionarios = null;

		try {
			funcionarios = funcionarioService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Funcionario>>(funcionarios, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Funcionario>>(funcionarios, HttpStatus.OK);

	}
	
	@DeleteMapping
	private ResponseEntity<Funcionario> deleteFuncionario(Funcionario funcionario) {

		Funcionario f = null;

		
		try {
			f = funcionarioService.removeFuncionario(funcionario);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Funcionario>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Funcionario>(f, HttpStatus.OK);
		
	}
}
