package sistemaDeVendas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sistemaDeVendas.domains.Produto;
import sistemaDeVendas.exceptions.CriacaoInvalidaException;
import sistemaDeVendas.exceptions.IdInvalidoException;
import sistemaDeVendas.exceptions.NotFoundException;
import sistemaDeVendas.exceptions.UpdateInvalidoException;
import sistemaDeVendas.repositorys.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto createProduto(Produto p) {
		
		if (p == null || p.getId() != null) {
			throw new CriacaoInvalidaException("Produto");
		}

		return produtoRepository.save(p);

	}

	public Produto updateProduto(Produto p)  {
		
		if (p == null || p.getId() == null) {
			throw new UpdateInvalidoException("Produto");
		}
		
		return produtoRepository.save(p);

	}

	public Produto readProduto(String idProduto) {
		
		if (idProduto == null) {
			throw new IdInvalidoException("Produto");
		}
		
		Optional<Produto> p = produtoRepository.findById(idProduto);
		
		return p.orElseThrow(() -> NotFoundException.build("Produto"));
		
//		if(!p.isPresent()) {
//			throw new ProdutoNaoEncontradoException();
//		}
		
	}

	public ArrayList<Produto> readAll() {
		return (ArrayList<Produto>) produtoRepository.findAll();
	}

	public Produto removeProduto(Produto p) {
		produtoRepository.deleteById(p.getId());
		return p;
	}

}
