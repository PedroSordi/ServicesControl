package br.com.servicesControl.entity;

import java.util.Date;
import java.util.List;

public class Pedido {
	private String placa;
	private List<Produto> listaProdutos;
	private Pessoa cliente;
	private List<Servico> servico;
	private Funcionario mecanico;
	private Date dataInicio;
	private Date dataFim;
	private int prioridade;

	public Pedido(List<Produto> listaProdutos, Pessoa cliente,
			List<Servico> servico, Funcionario mecanico, Date dataInicio,
			Date dataFim) {
		super();
		this.listaProdutos = listaProdutos;
		this.cliente = cliente;
		this.servico = servico;
		this.mecanico = mecanico;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Funcionario getMecanico() {
		return mecanico;
	}

	public void setMecanico(Funcionario mecanico) {
		this.mecanico = mecanico;
	}

}
