package br.ucsal.bes20222.testequalidade.locadora.dominio;

public class Modelo {

	private static Integer seq = 0;

	private Integer codigo;

	private String nome;

	public Modelo(String nome) {
		super();
		definirCodigo();
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private void definirCodigo() {		
		seq++;
		codigo = seq;
	}

}
