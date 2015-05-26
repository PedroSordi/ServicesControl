package br.com.servicesControl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "pedido")
public class Pedido implements Serializable {
	public final static String ID_FIELD_NAME = "id";
	
	private static final long serialVersionUID = -9143976339604386459L;
	@DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
	private long id;
	@DatabaseField
	private String placa;
	@DatabaseField
	private String descricao;
	@DatabaseField(foreign = true, foreignAutoRefresh = true)
	private Cliente cliente;
	@DatabaseField
	private Date dataInicio;
	@DatabaseField
	private String dataFim;
	@DatabaseField
	private int prioridade;
	@ForeignCollectionField
	private List<PedidoProduto> pedidoProduto;
	@ForeignCollectionField
	private List<PedidoServico> pedidoServico;

	public Pedido() {
		super();
	}

	public Pedido(long id, String placa, String descricao, Cliente cliente,
			Date dataInicio, String dataFim, int prioridade) {
		super();
		this.id = id;
		this.placa = placa;
		this.descricao = descricao;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.prioridade = prioridade;
	}

	public Pedido(String placa, String descricao, Cliente cliente,
			int prioridade) {
		this.placa = placa;
		this.descricao = descricao;
		this.cliente = cliente;
		this.prioridade = prioridade;
		this.dataInicio = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return getId() + " - " + getPlaca() + " - " + getCliente();
	}
}
