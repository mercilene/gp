package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_projeto")
public class Projeto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codProjeto;
	private String nome;
	private String descricao;
	private Date dataEntrega;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy="projeto")
	private List<Requisito> requisitos;
	
	public Projeto(){
		requisitos = new ArrayList<>();
	}

	public Projeto(Integer codProjeto, String nome, String descricao, Date dataEntrega, Cliente cliente) {
		super();
		this.codProjeto = codProjeto;
		this.nome = nome;
		this.descricao = descricao;
		this.dataEntrega = dataEntrega;
		this.cliente = cliente;
		cliente.addProjeto(this);
		requisitos = new ArrayList<>();
	}

	public Integer getCodProjeto() {
		return codProjeto;
	}

	public void setCodProjeto(Integer codProjeto) {
		this.codProjeto = codProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Requisito> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(List<Requisito> requisitos) {
		this.requisitos = requisitos;
	}
	
	public void addRequisitos(Requisito x){
		this.requisitos.add(x);
		x.setProjeto(this);
	}

	public void removeRequisitos(Projeto x){
		this.requisitos.remove(x);
	}

	
	@Override
	public String toString() {
		return "Projeto [codProjeto=" + codProjeto + ", nome=" + nome + ", descricao=" + descricao + ", dataEntrega="
				+ dataEntrega + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProjeto == null) ? 0 : codProjeto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (codProjeto == null) {
			if (other.codProjeto != null)
				return false;
		} else if (!codProjeto.equals(other.codProjeto))
			return false;
		return true;
	}

	
	public BigDecimal custoTotal() {
		BigDecimal soma = new BigDecimal("0.00");
		for (Requisito x : this.getRequisitos()) {
			soma = soma.add(x.getCusto());
		}
		return soma;
	}

	
	
}
