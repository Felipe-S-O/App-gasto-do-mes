package br.com.inottec.modelo;

public class OpcoesDeParcelas {
	
	private String quantidade;

	public OpcoesDeParcelas(String quantidade) {
		this.quantidade = quantidade;
	}

	
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return getQuantidade();
	}
	
	

}
