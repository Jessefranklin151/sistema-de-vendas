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

import sistemaDeVendas.domains.Categoria;
import sistemaDeVendas.services.CategoriaService;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> createCategoria(Categoria categoria) {

		Categoria c = null;

		try {
			c = categoriaService.createCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Categoria>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Categoria>(c, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Categoria> updateCategoria(Categoria categoria) {

		Categoria c = null;

		try {
			c = categoriaService.updateCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Categoria>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Categoria>(c, HttpStatus.OK);

	}

	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> readCategoria(@PathParam("id") String idCategoria) {

		Categoria c = null;

		try {
			c = categoriaService.readCategoria(idCategoria);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Categoria>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Categoria>(c, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Categoria>> readAll() {

		ArrayList<Categoria> categorias = null;

		try {
			categorias = categoriaService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Categoria>>(categorias, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Categoria>>(categorias, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Categoria> deleteCategoria(Categoria categoria) {

		Categoria c = null;

		try {
			c = categoriaService.removeCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Categoria>(c, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Categoria>(c, HttpStatus.OK);

	}

}
