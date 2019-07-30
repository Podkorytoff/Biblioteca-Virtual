package comprovante;
import java.time.LocalDate;
public class ComprovanteDevolucao extends Comprovante {

	// construtor da classe ComprovanteDevolucao
	public ComprovanteDevolucao (String titulo, LocalDate dataEmprestimo, LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, LocalDate.now());
	}
	
	@Override
	public String toString () {
		return "---------- Devolu��o realizada com sucessso! ----------" 
				+ "T�tulo:  " + getTitulo() + "\n" 
				+ "Data de empr�stimo: " + getDataEmprestimo() + "\n"
				+ "Data de devolu��o: " + getDataDevolucao() + "\n";
	}
	
	/*------------------------- getters e setters -----------------------------*/
	
	static public String getTitulo() {
		return titulo;
	}
	
	static public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
}
