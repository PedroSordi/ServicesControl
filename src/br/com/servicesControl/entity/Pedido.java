package br.com.servicesControl.entity;

import java.util.List;

public class Pedido {
	private String placa;
	private String nome;
	private List<Produto> listaProdutos;
	private Cliente cliente;
	private List<Servico> servico;
	private Funcionario mecanico;
	private String dataInicio;
	private String dataFim;
	private int prioridade;

	// Teste lista
	public Pedido(String placa, String nome, String dataInicio, int prioridade) {
		this.placa = placa;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.prioridade = prioridade;
	}

	public Pedido(String placa, List<Produto> listaProdutos, Cliente cliente,
			List<Servico> servico, Funcionario mecanico, String dataInicio,
			String dataFim, int prioridade) {
		super();
		this.placa = placa;
		this.listaProdutos = listaProdutos;
		this.cliente = cliente;
		this.servico = servico;
		this.mecanico = mecanico;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.prioridade = prioridade;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	public Funcionario getMecanico() {
		return mecanico;
	}

	public void setMecanico(Funcionario mecanico) {
		this.mecanico = mecanico;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
