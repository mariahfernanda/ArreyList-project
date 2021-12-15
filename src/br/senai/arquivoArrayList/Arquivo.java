package br.senai.arquivoArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;




public class Arquivo {
	
	DadosContato objDadosContato = new DadosContato();

	// CRIA E GRAVA OS DADOS NO ARQUIVO
	public boolean escrever(String caminho, String conteudo) {

		try {
			FileWriter arquivo = new FileWriter(caminho);
			PrintWriter gravarArquivo = new PrintWriter(arquivo);
			gravarArquivo.append(conteudo);
			gravarArquivo.close();
			return true;

		} catch (IOException e) {
			System.out.println("EERO: " + e.getMessage());
		}
		return false;
	}

	// LE DADOS NO ARQUIVO
	public DadosContato ler(String caminho) {

		String conteudo = "";

		// RECUPERAR OS DADOS DO ARQUIVO E ARMAZENA EM MEMÓRIA PARA A MANIPULAÇÃO
		try {
			FileReader arquivo = new FileReader(caminho);

			// ARMAZENA O CONTEÚDO DO ARQUIVO EM MEMÓRIA
			BufferedReader conteudoArquivo = new BufferedReader(arquivo);

			// RECUPERAR DADOS DO ARQUIVO
			String linha = "";
			linha = conteudoArquivo.readLine();

			while (linha != null) {
				Cadastro objContato = new Cadastro();
				
				String [] VetLinha = linha.split(";");
				
				objContato.setNome(VetLinha[0]);
				objContato.setEmail(VetLinha[1]);
				objContato.setTelefone(VetLinha[2]);
				objContato.setCidade(VetLinha[3]);
				
				objDadosContato.cadastrarContato(objContato);
				
				conteudo += linha + "\n";
				linha = conteudoArquivo.readLine();
			}

			conteudoArquivo.close();
			return objDadosContato;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return null;

		} 
	}

}
