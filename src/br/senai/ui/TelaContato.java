package br.senai.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.arquivoArrayList.Arquivo;
import br.senai.arquivoArrayList.Cadastro;
import br.senai.arquivoArrayList.DadosContato;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaContato extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("CADASTRO DE CONTATOS:");
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCidade;

	/***
	 * atributos de instancia de objetos CLASSE: Arquivo CLASSE: Cadastro CLASSE:
	 * DadosContato
	 ***/

	private Arquivo objArquivo;
	private Cadastro objContato;
	private DadosContato objDadosContatos;
	private String caminho;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaContato frame = new TelaContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaContato() {
		/****
		 * CRIAÇÃO DOS OBJETOS DAS CLASSE: Contato Arquivo DadosContato
		 ***/

		objContato = new Cadastro();
		objArquivo = new Arquivo();
		objDadosContatos = new DadosContato();
		/***
		 * CONFIGURA O CAMINHO DO ARQUIVO
		 ***/
		caminho = "Z:\\desktop\\caminho.txt";
		
		/***
		 * EXIBE TOTAL DE CONTATOS CADASTRADOS
		 */
		ArrayList<Cadastro> teste = new ArrayList<Cadastro>();
		
		teste = objDadosContatos.listarContatos();
		System.out.println("TOTAL DE CONTATOS: " + teste.size());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 241, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNome.setForeground(SystemColor.activeCaptionText);
		lblNome.setBounds(27, 54, 39, 14);
		contentPane.add(lblNome);

		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(20, 79, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefone.setBounds(10, 104, 76, 14);
		contentPane.add(lblTelefone);

		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setBounds(20, 129, 46, 14);
		contentPane.add(lblCidade);

		txtNome = new JTextField();
		txtNome.setBounds(77, 53, 266, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(77, 76, 266, 20);
		contentPane.add(txtEmail);

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(77, 101, 266, 20);
		contentPane.add(txtTelefone);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(77, 126, 266, 20);
		contentPane.add(txtCidade);

		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// AÇÃO DO BOTÃO CADASTRAR

				// RECEBR DADOS DIGITADOS
				objContato.setNome(txtNome.getText());
				objContato.setEmail(txtEmail.getText());
				objContato.setTelefone(txtTelefone.getText());
				objContato.setCidade(txtCidade.getText());

				// TRATANDO OS DADOS PARA A INSERÇÃO NO ARQUIVO TEXTO:
				String texto = "";
				texto = objContato.getNome() +";" + objContato.getEmail()
						+ ";" + objContato.getTelefone() + ";"
						+ objContato.getCidade() + ";";

//				System.out.println(texto);
				objArquivo.escrever(caminho, texto);

			}
		});
		btnCadastrar.setBackground(SystemColor.inactiveCaptionBorder);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCadastrar.setForeground(new Color(0, 0, 0));
		btnCadastrar.setBounds(30, 176, 138, 31);
		contentPane.add(btnCadastrar);
	}
}
