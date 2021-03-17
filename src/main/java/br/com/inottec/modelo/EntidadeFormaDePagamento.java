package br.com.inottec.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CARTAO")
public class EntidadeFormaDePagamento implements RestricaoEntidade {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@ManyToOne
	private EntidadeUsuario usuario;
	
	private String nome;
	
	private LocalDate vencimento;
	
	

	public EntidadeFormaDePagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EntidadeFormaDePagamento(String nome, LocalDate vencimento) {
		super();
		this.nome = nome;
		this.vencimento = vencimento;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntidadeUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(EntidadeUsuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
	
	
}