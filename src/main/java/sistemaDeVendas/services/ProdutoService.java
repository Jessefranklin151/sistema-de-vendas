package sistemaDeVendas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Produto;
import sistemaDeVendas.repositorys.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto createProduto(Produto p) {
		produtoRepository.save(p);
		return p;
	}

	public Produto updateProduto(Produto p) {
		Produto produtoBase = readProduto(p.getId());

		produtoBase.setCategoria(p.getCategoria());
		produtoBase.setMarca(p.getMarca());
		produtoBase.setNome(p.getNome());
		produtoBase.setQuantidade(p.getQuantidade());
		produtoBase.setValor(p.getValor());

		produtoRepository.save(produtoBase);

		return produtoBase;
	}

	public Produto readProduto(String idProduto) {
		return produtoRepository.findById(idProduto).get();
	}

	public ArrayList<Produto> readAll() {
		return (ArrayList<Produto>) produtoRepository.findAll();
	}

	public Produto removeProduto(Produto p) {
		produtoRepository.deleteById(p.getId());
		return p;
	}

}
