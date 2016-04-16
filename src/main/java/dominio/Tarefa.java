package dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_tarefa")
public class Tarefa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codTarefa;
	private String descricao;
	private Integer horas;
	
	@ManyToOne
	@JoinColumn(name="funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="requisito")
	private Requisito requisito;
	
	public Tarefa(){
	}

	public Tarefa(Integer codTarefa, String descricao, Integer horas, Funcionario funcionario, Requisito requisito) {
		super();
		this.codTarefa = codTarefa;
		this.descricao = descricao;
		this.horas = horas;
		this.funcionario = funcionario;
		funcionario.addTarefa(this);
		this.requisito = requisito;
		requisito.addTarefa(this);
	}

	
	public Integer getCodTarefa() {
		return codTarefa;
	}

	public void setCodTarefa(Integer codTarefa) {
		this.codTarefa = codTarefa;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Requisito getRequisito() {
		return requisito;
	}

	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}

	@Override
	public String toString() {
		return "Tarefa [codTarefa=" + codTarefa + ", descricao=" + descricao + ", horas=" + horas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codTarefa == null) ? 0 : codTarefa.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (codTarefa == null) {
			if (other.codTarefa != null)
				return false;
		} else if (!codTarefa.equals(other.codTarefa))
			return false;
		return true;
	}

	
}
