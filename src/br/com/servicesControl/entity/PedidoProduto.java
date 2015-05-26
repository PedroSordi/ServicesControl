package br.com.servicesControl.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pedido_produto")
public class PedidoProduto implements Serializable {
	public final static String USER_ID_FIELD_NAME = "user_id";
	public final static String POST_ID_FIELD_NAME = "post_id";
	
	private static final long serialVersionUID = 7055661674464031980L;
	@DatabaseField(generatedId = true, columnName = USER_ID_FIELD_NAME)
	private long id;
	@DatabaseField
	private int quantidade;
	@DatabaseField(canBeNull = false)
	private Produto produto;
	@DatabaseField(canBeNull = false)
	private Pedido pedido;

	public PedidoProduto() {
		super();
	}

	public PedidoProduto(long id, int quantidade, Produto produto, Pedido pedido) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
		this.pedido = pedido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
