package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import biblioteca.*;
import comprovante.*;

	public abstract class Usuario {
	private static List <Comprovante> historico;							// hist�rico de emp�stimos do usu�rio
	private String Nome; 													// nome do usuario
	private String Sobrenome; 												// sobrenome do usuario
	private String Email;													// e-mail do usuario
	private static int iD;													// n�mero de identifica��o do usu�rio
	private static int senha;												// senha do usu�rio
	private static int iDUniversal = 0; 									// vari�vel auxiliar para cria��o de um iD
	static int  qtdMax; 													// quantidade m�xima de livros para loca��o por usu�rio
	static int prazoMax;													// data m�xima que um livro pode ser alugado
	static LocalDate dataEmprestimo = LocalDate.now();						// calcula o dia de hoje
	static LocalDate dataPrevista = dataEmprestimo.plusDays(prazoMax);		// calcula a data de devolu��o baseado na data atual
	static LocalDate dataDevolucao = LocalDate.now();
	
	//construtor da classe abstrata usuario
	public Usuario (String Nome, String Sobrenome, String Email, int senha) {
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.Email = Email;
		setiD(iDUniversal++);
		setSenha(senha);
		setHistorico(new ArrayList<Comprovante>());
	}
	
	// m�todo para realizar empr�stimo
	public static void realizaEmprestimo (String titulo) {
		// se o limite de livros ainda n�o for atigido
		if (qtdMax > 0) {	
			// se o livro estiver disponivel				
			if( Biblioteca.buscaStatusLivro(titulo)) {   
			Biblioteca.Emprestimo(titulo);
			// cria comprovante de empr�stimo e coloca no hist�rico do usu�rio
			ComprovanteEmprestimo c = new ComprovanteEmprestimo (titulo, dataEmprestimo, dataPrevista);
			historico.add(c);
			System.out.print(c);
			// diminui em 1 a quantidade poss�veis futuros empr�stimos
			qtdMax--;
			}
			else
				System.out.println("Livro j� est� alugado. Imposs�vel realizar empr�stimo.");
		}
		else 
			System.out.println("Voc� atingiu o limite para a loca��o de livros. "
								+ "Devolva um livro e tente novamente");
	}
		
	// m�todo para realizar a devolu��o 
	public static void realizaDevolucao (String titulo) {
		Biblioteca.Devolucao(titulo);
	
		// resgata datas de empr�stimo e previs�o de devolu��o
		LocalDate emprest = null, previsao =  null;
		for (int i = 0; i < historico.size(); i++) {
			if (Comprovante.getTitulo().equals(titulo))	{
				emprest = Comprovante.getDataEmprestimo();
				previsao = Comprovante.getDataPrevista();
			}
		}
		// cria comprovante de devolu��o
		ComprovanteDevolucao c = new ComprovanteDevolucao(titulo, emprest, previsao);
		System.out.print(c);
		
		// se a data de devolu��o for ap�s a data prevista:
		if (dataDevolucao.isAfter(previsao)) {
				System.out.print("Aten��o! Devolu��o atrasada, voc� est� bloqueado por 7 dias.");	
		}
	}
	
	/* -------- fun��es getters e setters -------- */
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String newNome) {
		this.Nome = newNome;
	}
	public String getSobrenome() {
		return Sobrenome;
	}
	public void setSobrenome(String newSobrenome) {
		this.Sobrenome = newSobrenome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String newEmail) {
		this.Email = newEmail;
	}
	public static int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		Usuario.iD = iD;
	}
	public static int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		Usuario.senha = senha;
	}
	public static List<Comprovante> getHistorico() {
		return historico;
	}
	public static void setHistorico(List<Comprovante> historico) {
		Usuario.historico = historico;
	}
}
