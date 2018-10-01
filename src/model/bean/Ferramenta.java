package model.bean;

public class Ferramenta {
	
	private String id;
	private String tipo;
	private String descricao;
	private Boolean isDisponivel;
	
	
	public Ferramenta(String id, String tipo, String descricao, Boolean isDisponivel) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.isDisponivel = isDisponivel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getIsDisponivel() {
		return isDisponivel;
	}

	public void setIsDisponivel(Boolean isDisponivel) {
		this.isDisponivel = isDisponivel;
	}
	
}
