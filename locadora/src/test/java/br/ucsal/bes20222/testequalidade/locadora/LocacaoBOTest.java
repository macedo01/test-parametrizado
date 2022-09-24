package br.ucsal.bes20222.testequalidade.locadora;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import br.ucsal.bes20222.testequalidade.locadora.business.LocacaoBO;
import br.ucsal.bes20222.testequalidade.locadora.dominio.Modelo;
import br.ucsal.bes20222.testequalidade.locadora.dominio.Veiculo;
import br.ucsal.bes20222.testequalidade.locadora.dominio.enums.SituacaoVeiculoEnum;
import br.ucsal.bes20222.testequalidade.locadora.exception.VeiculoNaoEncontradoException;
import br.ucsal.bes20222.testequalidade.locadora.persistence.VeiculoDAO;

/**
 * Testes para os métodos da classe LocacaoBO.
 * 
 * @author claudioneiva
 *
 */
class LocacaoBOTest {

	/**
	 * Testar o cálculo do valor total de locação por 3 dias de 1 veículo fabricado
	 * em 2015. 
	 */
	@ParameterizedTest()
	@CsvSource(value = { "360.00:2022", "450.00:2017"}, delimiter = ':')
	void testarCalculoValorTotalLocacao1Veiculo3Dias(Double expectedRentValue, Integer anoDeReferencia) throws VeiculoNaoEncontradoException {
		VeiculoDAO dao = new VeiculoDAO();
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ABC-1234");
		veiculo.setModelo(new Modelo("Model X"));
		veiculo.setSituacao(SituacaoVeiculoEnum.DISPONIVEL);
		veiculo.setAnoFabricacao(2015);
		veiculo.setValorDiaria(150.00);

		dao.insert(veiculo);

		List<String> placas = Arrays.asList(
				veiculo.getPlaca()
		);

		Double rentValue = new LocacaoBO(dao).calcularValorTotalLocacao(placas, 3, LocalDate.of(anoDeReferencia, 01, 01));

		Assertions.assertEquals(expectedRentValue, rentValue);
	}

	/**
	 * Testar o cálculo do valor total de locação por 4 dias de 2 veículos fabricados
	 * em 2015.
	 */
	@ParameterizedTest()
	@CsvSource(value = { "960.00:2022", "1200.00:2017"}, delimiter = ':')
	void testarCalculoValorTotalLocacao2Veiculos4Dias(Double expectedRentValue, Integer anoDeReferencia) throws VeiculoNaoEncontradoException {

		VeiculoDAO dao = new VeiculoDAO();
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ABC-1234");
		veiculo.setModelo(new Modelo("Model X"));
		veiculo.setSituacao(SituacaoVeiculoEnum.DISPONIVEL);
		veiculo.setAnoFabricacao(2015);
		veiculo.setValorDiaria(150.00);

		Veiculo veiculo2 = new Veiculo();
		veiculo2.setPlaca("CBA-4321");
		veiculo2.setModelo(new Modelo("Model Y"));
		veiculo2.setSituacao(SituacaoVeiculoEnum.DISPONIVEL);
		veiculo2.setAnoFabricacao(2015);
		veiculo2.setValorDiaria(150.00);

		dao.insert(veiculo);
		dao.insert(veiculo2);

		List<String> placas = Arrays.asList(
				veiculo.getPlaca(),
				veiculo2.getPlaca()
		);


		Double rentValue = new LocacaoBO(dao).calcularValorTotalLocacao(placas, 4, LocalDate.of(anoDeReferencia,01,01));

		Assertions.assertEquals(expectedRentValue, rentValue);
	}

}
