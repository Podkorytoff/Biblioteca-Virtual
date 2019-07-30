package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import biblioteca.*;
import comprovante.*;

public class Professor extends Usuario {
																			// hist�rico de loca��es
	static int qtdMax = 10;													// quantidade m�xima de livros que um professor pode alugar
	static int prazoMax = 90;												// data m�xima que um livro pode ser alugado por um professor
	static LocalDate dataEmprestimo = LocalDate.now();						// calcula o dia de hoje
	static LocalDate dataPrevista = dataEmprestimo.plusDays(prazoMax);		// calcula o prazo de devolu��o
	static LocalDate dataDevolucao = LocalDate.now();						// calcula a data de devolu��o baseado na data atual
	
	static Scanner scan = new Scanner(System.in);
	
	//construtor da classe professor
	public Professor (String nome, String sobrenome, String email, int senha) {
		super (nome, sobrenome, email, senha);
		setHistorico(new ArrayList<Comprovante>());
	}
	
	// metodo para cadastrar um professor
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
				System.out.print(Professor.getHistorico());
		}
	}
}

