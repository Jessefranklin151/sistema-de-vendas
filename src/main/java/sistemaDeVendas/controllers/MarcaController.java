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

import sistemaDeVendas.domains.Marca;
import sistemaDeVendas.services.MarcaService;

@Controller
@RequestMapping(value = "/marca")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@PostMapping
	public ResponseEntity<Marca> createMarca(Marca marca) {

		return new ResponseEntity<Marca>(marcaService.createMarca(marca), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Marca> updateMarca(Marca marca) {

		return new ResponseEntity<Marca>(marcaService.updateMarca(marca), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Marca> readMarca(@PathParam("id") String idMarca) {

		return new ResponseEntity<Marca>(marcaService.readMarca(idMarca), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Marca>> readAll() {

		// TODO:
		ArrayList<Marca> marcas = null;

		try {
			marcas = marcaService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Marca>>(marcas, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Marca>>(marcas, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Marca> deleteMarca(Marca marca) {

		return new ResponseEntity<Marca>(marcaService.removeMarca(marca), HttpStatus.OK);

	}

}