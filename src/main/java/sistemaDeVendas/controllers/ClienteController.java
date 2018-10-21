package sistemaDeVendas.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sistemaDeVendas.domains.Cliente;
import sistemaDeVendas.services.ClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> createCliente(Cliente cliente) {

		return new ResponseEntity<Cliente>(clienteService.createCliente(cliente), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Cliente> updateCliente(Cliente cliente) {

		return new ResponseEntity<Cliente>(clienteService.updateCliente(cliente), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> readCliente(@PathVariable("id") String idCliente) {

		return new ResponseEntity<Cliente>(clienteService.readCliente(idCliente), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Cliente>> readAll() {

		ArrayList<Cliente> clientes = null;

		try {
			clientes = clienteService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Cliente>>(clientes, HttpStatus.BAD_REQUEST);
		}

		// TODO: arrumar o readdAll.
		return new ResponseEntity<ArrayList<Cliente>>(clientes, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Cliente> deleteCliente(Cliente cliente) {

		return new ResponseEntity<Cliente>(clienteService.removeCliente(cliente), HttpStatus.OK);

	}

}
