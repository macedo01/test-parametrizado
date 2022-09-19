package br.ucsal.bes20222.testequalidade.locadora.dominio;

import br.ucsal.bes20222.testequalidade.locadora.dominio.enums.SituacaoVeiculoEnum;

public class Veiculo {

	private String placa;

	private Integer anoFabricacao;

	private Modelo modelo;

	private Double valorDiaria;

	private SituacaoVeiculoEnum situacao = SituacaoVeiculoEnum.DISPONIVEL;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public SituacaoVeiculoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoVeiculoEnum situacao) {
		this.situacao = situacao;
	}

}
