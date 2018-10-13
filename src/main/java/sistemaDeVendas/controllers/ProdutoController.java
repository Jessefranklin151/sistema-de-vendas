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

import sistemaDeVendas.domains.Produto;
import sistemaDeVendas.services.ProdutoService;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping
	public ResponseEntity<Produto> createProduto(Produto produto) {

		Produto p = null;

		try {
			p = produtoService.createProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Produto>(p, HttpStatus.ACCEPTED);

	}

	@PutMapping
	public ResponseEntity<Produto> updateProduto(Produto produto) {

		Produto p = null;

		try {
			p = produtoService.updateProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Produto>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Produto>(p, HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> readProduto(@PathParam("id") String idProduto) {
		
		Produto p = null;
		
		try {
			p = produtoService.readProduto(idProduto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Produto>(p, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Produto>(p, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping
	public ResponseEntity<ArrayList<Produto>> readProdutos() {
		
		ArrayList<Produto> produtos = null;
		
		try {
			produtos = produtoService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Produto>>(produtos, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ArrayList<Produto>>(produtos, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping
	public ResponseEntity<Produto> deleteProduto(Produto produto) {
		
		Produto p = null;
		
		try {
			p = produtoService.removeProduto(produto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Produto>(p, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Produto>(p, HttpStatus.OK);
	}
	

}
