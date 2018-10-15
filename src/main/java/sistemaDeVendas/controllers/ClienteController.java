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

import sistemaDeVendas.domains.Cliente;
import sistemaDeVendas.services.ClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> createCliente(Cliente cliente) {

		Cliente c = null;

		try {
			c = clienteService.createCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Cliente>(c, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Cliente> updateCliente(Cliente cliente) {

		Cliente c = null;

		try {
			c = clienteService.updateCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Cliente>(c, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> readCliente(@PathParam("id") String idCliente) {
		
		Cliente c = null;
		
		try {
			c = clienteService.readCliente(idCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
		
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

		return new ResponseEntity<ArrayList<Cliente>>(clientes, HttpStatus.OK);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Cliente> deleteCliente(Cliente cliente) {
		
		Cliente c = null;
		
		try {
			c = clienteService.removeCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Cliente>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
		
	}

}
