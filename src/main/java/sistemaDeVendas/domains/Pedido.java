package sistemaDeVendas.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pedido {

	@Id
	private String id;
	private Integer quantidade;
	private Produto produto;
	private Double valorTotalPedido;

	public String getId() {
		return id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(Double valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

}
