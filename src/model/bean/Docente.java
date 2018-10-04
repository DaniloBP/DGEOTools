package model.bean;

public class Docente extends Usuario {
	
	
	public Docente(String siape, String cpf, String nome, String email) {
		
		super(siape, cpf, nome, email);
		
		// Docentes não devem ter um limite do número de ferramentas solicitadas.
		this.isLimitado = false;				
	}

}
