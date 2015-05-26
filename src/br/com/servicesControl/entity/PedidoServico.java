package br.com.servicesControl.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pedido_servico")
public class PedidoServico implements Serializable {
	private static final long serialVersionUID = -5999243051936912767L;
	@DatabaseField(id = true)
	private long id;
	@DatabaseField(canBeNull = false)
	private Servico servico;
	@DatabaseField(canBeNull = false)
	private Pedido pedido;

	public PedidoServico() {
		super();
	}

	public PedidoServico(long id, Servico servico, Pedido pedido) {
		super();
		this.id = id;
		this.servico = servico;
		this.pedido = pedido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
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
