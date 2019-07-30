package usuario;

public abstract class Usuario {
	private String Nome; 					// nome do usuario
	private String Sobrenome; 				// sobrenome do usuario
	private String Email;					// e-mail do usuario
	private static int iD;							// n�mero de identifica��o do usu�rio
	private static int senha;						// senha do usu�rio
	private static int iDUniversal = 0; 	// vari�vel auxiliar para cria��o de um iD
	
	//construtor da classe abstrata usuario
	public Usuario (String Nome, String Sobrenome, String Email, int senha) {
		this.Nome = Nome;
		this.Sobrenome = Sobrenome;
		this.Email = Email;
		setiD(iDUniversal++);
		setSenha(senha);
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
}
