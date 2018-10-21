package sistemaDeVendas;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sistemaDeVendas.domains.Cliente;
import sistemaDeVendas.domains.Endereco;
import sistemaDeVendas.domains.Pedido;
import sistemaDeVendas.domains.Produto;
import sistemaDeVendas.domains.Venda;
import sistemaDeVendas.services.ClienteService;
import sistemaDeVendas.services.ProdutoService;
import sistemaDeVendas.services.VendaService;

@SpringBootApplication
@EnableAutoConfiguration
public class App implements CommandLineRunner {
	
	@Autowired
	private VendaService vendaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProdutoService produtoService;

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}

	public void run(String... args) {
		
		Venda venda = new Venda();
		
		Produto produto = new Produto();
		produto.setNome("testeProduto");
		Pedido p1 = new Pedido();
		p1.setProduto(produto);
		Produto produto2 = new Produto();
		produto2.setNome("testeProduto2");
		Pedido p2 = new Pedido();
		p2.setProduto(produto2);
		produtoService.createProduto(produto);
		produtoService.createProduto(produto2);
		
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(p1);
		pedidos.add(p2);
		
		venda.setPedidos(pedidos);
		
		//System.out.println("teste1");
		
		for (Venda v : vendaService.readAll()) {
			for (Pedido pedido : v.getPedidos()) {
				System.out.println(pedido.getProduto().getNome());
			}
		}
		//System.out.println("teste2");
		
		
		Endereco endereco = new Endereco("rua das colheres", "mesa", Short.parseShort("1234"),"sala de jantar", "casa");
		Cliente c = new Cliente("jose", 44433444L, endereco);
		clienteService.createCliente(c);
		venda.setCliente(c);
		
		//System.out.println("teste3");
		
		vendaService.createVenda(venda);
	
	}

}
