package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import comprovante.Comprovante;

public class Professor extends Usuario {
	// hist�rico de loca��es
	static int qtdMax = 10;													// quantidade m�xima de livros que um professor pode alugar
	static int prazoMax = 90;												// data m�xima que um livro pode ser alugado por um professor
	static LocalDate dataEmprestimo = LocalDate.now();						// calcula o dia de hoje
	static LocalDate dataPrevista = Professor.dataEmprestimo.plusDays(Professor.prazoMax);		// calcula o prazo de devolu��o
	static LocalDate dataDevolucao = LocalDate.now();						// calcula a data de devolu��o baseado na data atual

	public static Scanner scan = new Scanner(System.in);

	//construtor da classe professor
	public Professor (final String nome, final String sobrenome, final int iD, final int senha) {
		super (nome, sobrenome, iD, senha);
		this.setHistorico(new ArrayList<Comprovante>());
	}

	public Professor () {

	}
}

