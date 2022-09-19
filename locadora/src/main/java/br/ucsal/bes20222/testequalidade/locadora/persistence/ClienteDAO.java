package br.ucsal.bes20222.testequalidade.locadora.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.bes20222.testequalidade.locadora.dominio.Cliente;
import br.ucsal.bes20222.testequalidade.locadora.exception.ClienteNaoEncontradoException;

public class ClienteDAO {

	private static List<Cliente> clientes = new ArrayList<>();

	public static Cliente obterPorCpf(String cpf) throws ClienteNaoEncontradoException {
		for (Cliente cliente : clientes) {
			if (cliente.getCpf().equalsIgnoreCase(cpf)) {
				return cliente;
			}
		}
		throw new ClienteNaoEncontradoException();
	}
	
	public static void insert(Cliente cliente){
		clientes.add(cliente);
	}

}
