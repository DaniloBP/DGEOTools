package model.bean;

import java.util.Date;
import java.util.List;

public class Emprestimo {
	
	private String id;
	
	private Date dataHora_Inicio;
	private Date dataHora_Fim;
	
	private Usuario requisitante;
	
	private List<Ferramenta> ferramentas;
	
	private Servidor servidorResponsavel_Inicio;
	private Servidor servidorResponsavel_Fim;
	
	private Boolean isAtivo;

	public Emprestimo(Date dataHora_Inicio, Usuario requisitante, Servidor servidorResponsavel_Inicio) {
		super();
		this.dataHora_Inicio = dataHora_Inicio;
		this.requisitante = requisitante;
		this.servidorResponsavel_Inicio = servidorResponsavel_Inicio;
	}
	
	
	public boolean addFerramenta (Ferramenta ferramenta) {
		
		// Tem que ser verificada a possibilidade da adição de + uma ferramenta.
		this.getFerramentas().add(ferramenta);
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataHora_Inicio() {
		return dataHora_Inicio;
	}

	public void setDataHora_Inicio(Date dataHora_Inicio) {
		this.dataHora_Inicio = dataHora_Inicio;
	}

	public Date getDataHora_Fim() {
		return dataHora_Fim;
	}

	public void setDataHora_Fim(Date dataHora_Fim) {
		this.dataHora_Fim = dataHora_Fim;
	}

	public Usuario getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(Usuario requisitante) {
		this.requisitante = requisitante;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public Servidor getServidorResponsavel_Inicio() {
		return servidorResponsavel_Inicio;
	}

	public void setServidorResponsavel_Inicio(Servidor servidorResponsavel_Inicio) {
		this.servidorResponsavel_Inicio = servidorResponsavel_Inicio;
	}

	public Servidor getServidorResponsavel_Fim() {
		return servidorResponsavel_Fim;
	}

	public void setServidorResponsavel_Fim(Servidor servidorResponsavel_Fim) {
		this.servidorResponsavel_Fim = servidorResponsavel_Fim;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
		
}
