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

import sistemaDeVendas.domains.Categoria;
import sistemaDeVendas.services.CategoriaService;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> createCategoria(Categoria categoria) {

		return new ResponseEntity<Categoria>(categoriaService.createCategoria(categoria), HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Categoria> updateCategoria(Categoria categoria) {

		return new ResponseEntity<Categoria>(categoriaService.updateCategoria(categoria), HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> readCategoria(@PathParam("id") String idCategoria) {

		return new ResponseEntity<Categoria>(categoriaService.readCategoria(idCategoria), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Categoria>> readAll() {

		// TODO: arrumar o ReadAll.
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

		return new ResponseEntity<Categoria>(categoriaService.removeCategoria(categoria), HttpStatus.OK);

	}

}
