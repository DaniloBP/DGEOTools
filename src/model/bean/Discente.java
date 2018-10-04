package model.bean;

public class Discente extends Usuario {
	
	public Discente(String siape, String cpf, String nome, String email) {
		
		super(siape, cpf, nome, email);
		
		// Discentes só devem ter uma ferramenta de cada tipo por Empréstimo solicitado.
		this.isLimitado = true;				
	}
}
