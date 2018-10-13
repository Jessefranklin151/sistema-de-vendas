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

import sistemaDeVendas.domains.Fornecedor;
import sistemaDeVendas.services.FornecedorService;

@Controller
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping
	private ResponseEntity<Fornecedor> createFornecedor(Fornecedor fornecedor) {

		Fornecedor f = null;

		try {
			f = fornecedorService.createFornecedor(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Fornecedor>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Fornecedor>(f, HttpStatus.OK);

	}

	@PutMapping
	private ResponseEntity<Fornecedor> updateFornecedor(Fornecedor fornecedor) {

		Fornecedor f = null;

		try {
			f = fornecedorService.updateFornecedor(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Fornecedor>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Fornecedor>(f, HttpStatus.OK);

	}

	@GetMapping("/fornecedor/{id}")
	public ResponseEntity<Fornecedor> readFornecedor(@PathParam("id") String idFornecedor) {

		Fornecedor f = null;

		try {
			f = fornecedorService.readFornecedor(idFornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Fornecedor>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Fornecedor>(f, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Fornecedor>> readAll() {

		ArrayList<Fornecedor> fornecedores = null;

		try {
			fornecedores = fornecedorService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Fornecedor>>(fornecedores, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Fornecedor>>(fornecedores, HttpStatus.OK);

	}
	
	@DeleteMapping
	public ResponseEntity<Fornecedor> deleteFornecedor(Fornecedor fornecedor) {
		
		Fornecedor f = null;
		
		try {
			f = fornecedorService.removeFornecedor(fornecedor);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Fornecedor>(f, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Fornecedor>(f, HttpStatus.OK);
		
	}

}
