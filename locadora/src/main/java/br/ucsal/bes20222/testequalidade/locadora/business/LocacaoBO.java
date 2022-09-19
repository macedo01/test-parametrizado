package br.ucsal.bes20222.testequalidade.locadora.business;

import java.time.LocalDate;
import java.util.List;

import br.ucsal.bes20222.testequalidade.locadora.dominio.Veiculo;
import br.ucsal.bes20222.testequalidade.locadora.exception.VeiculoNaoEncontradoException;
import br.ucsal.bes20222.testequalidade.locadora.persistence.VeiculoDAO;

public class LocacaoBO {

	public VeiculoDAO veiculoDAO;

	public LocacaoBO(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	/**
	 * Calcula o valor total da locação dos veículos para uma quantidade de dias.
	 * Veículos com mais de 5 anos de fabricação têm desconto de 20%.
	 * 
	 * @param veiculos              veículos que serão locados
	 * @param quantidadeDiasLocacao quantidade de dias de locação
	 * @return
	 * @throws VeiculoNaoEncontradoException
	 */
	public Double calcularValorTotalLocacao(List<String> placas, Integer quantidadeDiasLocacao,
			LocalDate dataReferencia) throws VeiculoNaoEncontradoException {
		Double total = 0d;
		Double valorLocacaoVeiculo;
		Integer anoAtual = dataReferencia.getYear();
		List<Veiculo> veiculos = veiculoDAO.obterPorPlacas(placas);

		for (Veiculo veiculo : veiculos) {
			valorLocacaoVeiculo = veiculo.getValorDiaria() * quantidadeDiasLocacao;
			if (veiculo.getAnoFabricacao() < anoAtual - 5) {
				valorLocacaoVeiculo *= .8;
			}
			total += valorLocacaoVeiculo;
		}

		return total;
	}

}
