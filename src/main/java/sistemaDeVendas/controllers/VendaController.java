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

import sistemaDeVendas.domains.Venda;
import sistemaDeVendas.services.VendaService;

@Controller
@RequestMapping(value = "/venda")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@PostMapping
	public ResponseEntity<Venda> createVenda(Venda venda) {

		return new ResponseEntity<Venda>(vendaService.createVenda(venda), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Venda> updateVenda(Venda venda) {

		return new ResponseEntity<Venda>(vendaService.updateVenda(venda), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Venda> readVenda(@PathParam("id") String idVenda) {

		return new ResponseEntity<Venda>(vendaService.readVenda(idVenda), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Venda>> readAll() {

		//TODO: arrumar o readAll;
		ArrayList<Venda> vendas = null;

		try {
			vendas = vendaService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Venda>>(vendas, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Venda>>(vendas, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Venda> deleteVenda(Venda venda) {

		Venda v = null;

		try {
			v = vendaService.removeVenda(venda);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Venda>(v, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Venda>(v, HttpStatus.OK);

	}

}
