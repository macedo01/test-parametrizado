package br.ucsal.bes20222.testequalidade.locadora.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes20222.testequalidade.locadora.dominio.Veiculo;
import br.ucsal.bes20222.testequalidade.locadora.exception.VeiculoNaoEncontradoException;

public class VeiculoDAO {

	private List<Veiculo> veiculos = new ArrayList<>();

	public List<Veiculo> obterPorPlacas(List<String> placas) throws VeiculoNaoEncontradoException {
		List<Veiculo> veiculosSelecionados = new ArrayList<>();
		for (String placa : placas) {
			veiculosSelecionados.add(obterPorPlaca(placa));
		}
		return veiculosSelecionados;
	}

	public Veiculo obterPorPlaca(String placa) throws VeiculoNaoEncontradoException {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
				return veiculo;
			}
		}
		throw new VeiculoNaoEncontradoException();
	}

	public void insert(Veiculo veiculo) {
		veiculos.add(veiculo);
	}

}
