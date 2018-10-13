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

		Marca m = null;

		try {
			m = marcaService.createMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Marca>(m, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Marca>(m, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Marca> updateMarca(Marca marca) {

		Marca p = null;

		try {
			p = marcaService.updateMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Marca>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Marca>(p, HttpStatus.OK);

	}

	@GetMapping("/marca/{id}")
	public ResponseEntity<Marca> readMarca(@PathParam("id") String idMarca) {

		Marca p = null;

		try {
			p = marcaService.readMarca(idMarca);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Marca>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Marca>(p, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Marca>> readAll() {

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

		Marca m = null;

		try {
			m = marcaService.removeMarca(marca);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Marca>(m, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Marca>(m, HttpStatus.OK);

	}

}