package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import biblioteca.Biblioteca;

public class Professor extends Usuario {
	
	private static List <String> historico;	// hist�rico de loca��es
	static int qtdMax = 10;					// quantidade m�xima de livros que um professor pode alugar
	static int prazoMax = 90;				// data m�xima que um livro pode ser alugado por um professor
	static Scanner scan = new Scanner(System.in);
	
	//construtor da classe professor
	public Professor (String nome, String sobrenome, String email, int senha) {
		super (nome, sobrenome, email, senha);
		setHistorico(new ArrayList<String>());
	}
	
	//metodo para realizar emprestimos
	public static void realizaEmprestimo (String titulo) {
		// se o limite de livros ainda n for atigido	
		if (qtdMax > 0) {
			// se o livro estiver disponivel					
			if( Biblioteca.buscaStatusLivro(titulo)) { 
			Biblioteca.Emprestimo(titulo);
			historico.add(titulo);
			System.out.println("Empr�stimo realizado com sucesso!");
			qtdMax--;
		}
		else
			System.out.println("Livro j� est� alugado. Imposs�vel realizar empr�stimo.");
		}
		else 
			System.out.println("Voc� atingiu o limite para a loca��o de livros. "
					+ "Devolva um livro e tente novamente");
	}
	
	// metodo para realizar a devolucao
	public static void realizaDevolucao (String titulo) {
		Biblioteca.Devolucao(titulo);
	}
	
	public static void cadastraProfessor () {
		System.out.println("Digite o nome, sobrenome, email e nova senha.");
		String nome = scan.nextLine();
		String sobrenome = scan.nextLine();
		String email = scan.nextLine();
		int senha = scan.nextInt();
		Professor p = new Professor(nome, sobrenome, email, senha);
		Biblioteca.getUsuarioProf().add(p);
	}
	
	// m�todo para buscar hist�rico de professor
	public static void buscaHistoricoProf (int iD, int senha) {
		for (int i = 0; i < Biblioteca.getUsuarioProf().size(); i++) {
			if (Professor.getiD() == iD && Professor.getSenha() == senha)	
				System.out.println(Professor.getHistorico());
		}
	}
	
	public static void setHistorico(List<String> historico) {
		Professor.historico = historico;
	}
	
	public static List<String> getHistorico() {
		return historico;
	}
}

