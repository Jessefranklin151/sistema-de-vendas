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

		return new ResponseEntity<Funcionario>(funcionarioService.createFuncionario(funcionario), HttpStatus.OK);

	}

	@PutMapping
	private ResponseEntity<Funcionario> updateFuncionario(Funcionario funcionario) {

		return new ResponseEntity<Funcionario>(funcionarioService.updateFuncionario(funcionario), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> readFornecedor(@PathParam("id") String idFuncionario) {

		return new ResponseEntity<Funcionario>(funcionarioService.readFuncionario(idFuncionario), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Funcionario>> readAll() {

		// TODO: arruamr o readAll;
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

		return new ResponseEntity<Funcionario>(funcionarioService.removeFuncionario(funcionario), HttpStatus.OK);

	}
}
