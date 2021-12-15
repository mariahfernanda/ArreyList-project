package br.senai.arquivoArrayList;

public class Main {

	public static void main(String[] args) {

		// declaração das variáveis/objetos
		Arquivo objArquivo = new Arquivo();
		String caminho = "Z:\\desktop\\contato.txt";

		// teste gravação de arquivo
		DadosContato objDadosContato = new DadosContato();

		Cadastro objContato1 = new Cadastro("Paulo", "ana@gmail.com", "1111-2222", "Jandira");
		Cadastro objContato2 = new Cadastro("Maria", "maria@gmail.com", "7210-8803", "Barueri");
		Cadastro objContato3 = new Cadastro("Eduardo", "eduardo@gmail.com", "9867-3654", "Osasco");
		Cadastro objContato4 = new Cadastro("Monica", "menica@gmail.com", "7450-3361", "Itapavi");

		objDadosContato.cadastrarContato(objContato1);
		objDadosContato.cadastrarContato(objContato2);
		objDadosContato.cadastrarContato(objContato3);
		objDadosContato.cadastrarContato(objContato4);

		// oque queremos gravar
		/*
		 * "Paulo", "ana@gmail.com", "1111-2222","Jandira" "Maria", "maria@gmail.com",
		 * "7210-8803","Barueri" "Eduardo", "eduardo@gmail.com", "9867-3654","Osasco"
		 * "Monica", "menica@gmail.com", "7450-3361","Itapavi"
		 */

		String texto = "";
		
		
		
//		for (Cadastro c : objDadosContato.listarContatos()) {
//			System.out.println("Nome: " + c.getNome() + "   Email: " + c.getEmail() + "   Telefone: " + c.getTelefone()
//					+ "   Cidade: " + c.getCidade());
//			texto += c.getNome() + ";" + c.getEmail() + ";" + c.getTelefone() + ";" + c.getCidade() + ";" + "\n";
//		}fim do for
		objArquivo.escrever(caminho, texto);

	}

}
