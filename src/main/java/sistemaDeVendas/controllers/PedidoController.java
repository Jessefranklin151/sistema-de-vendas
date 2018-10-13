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

import sistemaDeVendas.domains.Pedido;
import sistemaDeVendas.services.PedidoService;

@Controller
@RequestMapping(value = "/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<Pedido> createPedido(Pedido pedido) {

		Pedido p = null;

		try {
			p = pedidoService.creatPedido(pedido);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pedido>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Pedido>(p, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Pedido> updatePedido(Pedido pedido) {

		Pedido p = null;

		try {
			p = pedidoService.updatePedido(pedido);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pedido>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Pedido>(p, HttpStatus.OK);

	}

	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> readPedido(@PathParam("id") String idPedido) {

		Pedido p = null;

		try {
			p = pedidoService.readPedido(idPedido);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pedido>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Pedido>(p, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<ArrayList<Pedido>> readAll() {

		ArrayList<Pedido> pedidos = null;

		try {
			pedidos = pedidoService.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ArrayList<Pedido>>(pedidos, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<ArrayList<Pedido>>(pedidos, HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Pedido> deletePedido(Pedido pedido) {

		Pedido p = null;

		try {
			p = pedidoService.removePedido(pedido);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Pedido>(p, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Pedido>(p, HttpStatus.OK);

	}

}
