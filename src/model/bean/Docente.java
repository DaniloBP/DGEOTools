package model.bean;

public class Docente extends Requisitante {
	
	
	public Docente(String siape, String cpf, String nome, String email) {
		
		super(siape, cpf, nome, email);
		
		// Docentes n�o devem ter um limite do n�mero de ferramentas solicitadas.
		this.isLimitado = false;				
	}

}
