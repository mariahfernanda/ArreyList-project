package br.senai.arquivoArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystemNotFoundException;

import javax.annotation.processing.FilerException;

public class Arquivo {

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
	public String ler(String caminho) {

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
				conteudo += linha + "\n";
				linha = conteudoArquivo.readLine();
			}

			conteudoArquivo.close();
			return conteudo;

		} catch (IOException e) {

			System.out.println("ERRO: " + e.getMessage());
			return "";

		} catch (FileSystemNotFoundException e) {

			System.out.println("ERRO: " + e.getMessage());
			return "";

		}
	}

}
