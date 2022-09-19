package br.ucsal.bes20222.testequalidade.locadora.dominio;

import java.util.Date;
import java.util.List;

public class Locacao {

	private static Integer seq = 0;
	
	private Integer numeroContrato;

	private Cliente cliente;

	private List<Veiculo> veiculos;

	private Date dataLocacao;

	private Integer quantidadeDiasLocacao;

	private Date dataDevolucao;

	public Locacao(Cliente cliente, List<Veiculo> veiculos, Date dataLocacao, Integer quantidadeDiasLocacao) {
		super();
		definirNumeroContrato();
		this.cliente = cliente;
		this.veiculos = veiculos;
		this.dataLocacao = dataLocacao;
		this.quantidadeDiasLocacao = quantidadeDiasLocacao;
	}

	public Integer getNumeroContrato() {
		return numeroContrato;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public Date getDataLocacao() {
		return dataLocacao;
	}

	public Integer getQuantidadeDiasLocacao() {
		return quantidadeDiasLocacao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	private void definirNumeroContrato() {
		seq++;
		numeroContrato = seq;
	}

}
