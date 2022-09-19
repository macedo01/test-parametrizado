package br.ucsal.bes20222.testequalidade.locadora.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes20222.testequalidade.locadora.dominio.Locacao;
import br.ucsal.bes20222.testequalidade.locadora.exception.LocacaoNaoEncontradaException;

public class LocacaoDAO {

	private static List<Locacao> locacoes = new ArrayList<>();

	public static Locacao obterPorNumeroContrato(Integer numeroContrato) throws LocacaoNaoEncontradaException {
		for (Locacao locacao : locacoes) {
			if (locacao.getNumeroContrato().equals(numeroContrato)) {
				return locacao;
			}
		}
		throw new LocacaoNaoEncontradaException();
	}

	public static void insert(Locacao locacao) {
		locacoes.add(locacao);
	}

}
