package br.ucsal.bes20222.testequalidade.locadora.util;

import java.util.Date;
import java.util.List;

import br.ucsal.bes20222.testequalidade.locadora.exception.CampoObrigatorioNaoInformado;

public class ValidadorUtil {

	public static void validarCampoObrigatorio(Date data, String campo) throws CampoObrigatorioNaoInformado {
		if (data == null) {
			throw new CampoObrigatorioNaoInformado(campo);
		}
	}

	public static void validarCampoObrigatorio(Integer numero, String campo) throws CampoObrigatorioNaoInformado {
		if (numero == null) {
			throw new CampoObrigatorioNaoInformado(campo);
		}
	}

	public static void validarCampoObrigatorio(List<? extends Object> itens, String campo) throws CampoObrigatorioNaoInformado {
		if (itens == null || itens.isEmpty()) {
			throw new CampoObrigatorioNaoInformado(campo);
		}
	}

}
