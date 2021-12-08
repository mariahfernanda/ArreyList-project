package br.senai.arquivoArrayList;

import java.util.ArrayList;

public class DadosContato {

	// ATRIBUTOS
	Cadastro contato = new Cadastro();

	// Cadastro contato2 = new Cadastro("NOME", "EMAIL", "TELEFONE", "CIDADE");
	ArrayList<Cadastro> contatos = new ArrayList<Cadastro>();

	// MÉTODOS
	public void cadastrarContato(Cadastro c) {
		contatos.add(c);
	}

	public ArrayList<Cadastro> listarContatos() {
		return contatos;
	}
	
	public int contarContatos() {
		return contatos.size();
	}
	
}
