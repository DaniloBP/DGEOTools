package model.bean;

public class Discente extends Requisitante {
	
	public Discente(String siape, String cpf, String nome, String email) {
		
		super(siape, cpf, nome, email);
		
		// Discentes s� devem ter uma ferramenta de cada tipo por Empr�stimo solicitado.
		this.isLimitado = true;				
	}
}
