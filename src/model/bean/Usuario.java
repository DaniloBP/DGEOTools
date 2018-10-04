package model.bean;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	protected String matricula;
	protected String cpf;
	protected String nome;
	protected String email;
	
	protected Boolean isLimitado;

	protected Emprestimo emprestimoAtivo;
	protected List<Emprestimo> historicoEmprestimos;
	
	public Usuario() {
		
	}
	
	// Construtor
	public Usuario(String matricula, String cpf, String nome, String email) {
		super();
		
		this.matricula = matricula;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		
		// Todo Requisitante assim que cadastrado n�o deve ter nenhum empr�stimo ativo, logicamente.
		this.emprestimoAtivo = null;
		this.historicoEmprestimos = new ArrayList<>();
	}
	
	// Cria um NOVO empr�stimo.
	public boolean createEmprestimoAtivo(Emprestimo emprestimo) {
		
		if (hasEmprestimoAtivo()) {
			// O requisitante j� possui um Empr�stimo ativo. 
			// Caso queira e possa pegar mais algum material o empr�stimo ATIVO deve ser EDITADO.
			return false;
		}
		
		this.emprestimoAtivo = emprestimo;
		// Empr�stimo criado com sucesso.
		return true;
	}
	
	// Encerra o Empr�stimo ativo/atual.
	public boolean finishEmprestimoAtivo() {
		
		this.historicoEmprestimos.add(emprestimoAtivo);
		this.emprestimoAtivo = null;		
		// Empr�stimo encerrado com sucesso.
		return true;
	}
	
	public boolean hasEmprestimoAtivo() {
		
		if(this.emprestimoAtivo != null) {
			return true;
		}
		
		return false;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Boolean getIsLimitado() {
		return isLimitado;
	}

	public void setIsLimitado(Boolean isLimitado) {
		this.isLimitado = isLimitado;
	}

	public Emprestimo getEmprestimoAtivo() {
		return emprestimoAtivo;
	}

	public void setEmprestimoAtivo(Emprestimo emprestimoAtivo) {
		this.emprestimoAtivo = emprestimoAtivo;
	}

}
