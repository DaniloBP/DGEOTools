package model.bean;

public class Servidor {
	
	private String siape;
	private String nome;
	private String email;
	
	private String userName;
	private String password;
	
	
	public Servidor(String siape, String nome, String email, String userName, String password) {
		super();
		this.siape = siape;
		this.nome = nome;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}


	public String getSiape() {
		return siape;
	}


	public void setSiape(String siape) {
		this.siape = siape;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}	
	
}
