package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Produto;
import sistemaDeVendas.repositorys.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public void creatProduto(Produto p) {
		produtoRepository.save(p);
	}

	public void updateProduto(Produto p) {
		Produto produtoBase = readProduto(p);

		produtoBase.setCategoria(p.getCategoria());
		produtoBase.setMarca(p.getMarca());
		produtoBase.setNome(p.getNome());
		produtoBase.setQuantidade(p.getQuantidade());
		produtoBase.setValor(p.getValor());

		produtoRepository.save(produtoBase);

	}

	public Produto readProduto(Produto p) {
		return produtoRepository.findById(p.getId()).get();
	}
	
	public ArrayList<Produto> readAll() {
		return (ArrayList<Produto>) produtoRepository.findAll();
	}
	
	public void removeProduto(Produto p) {
		produtoRepository.deleteById(p.getId());
	}
 }
