package comprovante;
import java.time.LocalDate;

public class ComprovanteEmprestimo extends Comprovante {
	
	// construtor da classe ComprovanteEmprestimo
	public ComprovanteEmprestimo (String titulo, LocalDate dataEmprestimo, LocalDate dataPrevista) {
		super (titulo, dataEmprestimo, dataPrevista, dataPrevista);	
	}
	
	@Override
	public String toString () {
		return "---------- Empr�stimo realizado com sucessso ----------!" 
				+ "Descri��o:  " + getTitulo() + "\n" 
				+ "Data de empr�stimo: " + getDataEmprestimo() + "\n"
				+ "Prazo de devolu��o: " + getDataPrevista() + "\n";
	}
	
	/*------------------------- getters e setters -----------------------------*/
	
	static public String getTitulo() {
		return titulo;
	}
	
	static public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	static public LocalDate getDataPrevista() {
		return dataPrevista;
	}
}
