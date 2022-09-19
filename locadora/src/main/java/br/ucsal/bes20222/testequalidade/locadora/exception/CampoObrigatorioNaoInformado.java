package br.ucsal.bes20222.testequalidade.locadora.exception;

public class CampoObrigatorioNaoInformado extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CampoObrigatorioNaoInformado(String campo) {
		super("Campo obrigatório "+campo+" não informado.");
	}

}
