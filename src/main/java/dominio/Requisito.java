package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@Table(name="tb_requisito")
public class Requisito implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codRequisito;
	private String descricao;
	private Integer horasPrevistas;
	private BigDecimal custo;
	
	@ManyToOne
	@JoinColumn(name="projeto")
	private Projeto projeto;
	
	@OneToMany(mappedBy="requisito")
	private List<Tarefa> tarefas; 
	
	public Requisito(){
		tarefas = new ArrayList<>();
	}

	public Requisito(Integer codRequisito, String descricao, Integer horasPrevistas, BigDecimal custo,
			Projeto projeto) {
		super();
		this.codRequisito = codRequisito;
		this.descricao = descricao;
		this.horasPrevistas = horasPrevistas;
		this.custo = custo;
		this.projeto = projeto;
		projeto.addRequisitos(this);
		tarefas = new ArrayList<>();
	}

	public Integer getCodRequisito() {
		return codRequisito;
	}

	public void setCodRequisito(Integer codRequisito) {
		this.codRequisito = codRequisito;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getHorasPrevistas() {
		return horasPrevistas;
	}

	public void setHorasPrevistas(Integer horasPrevistas) {
		this.horasPrevistas = horasPrevistas;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public void addTarefa(Tarefa x){
		this.tarefas.add(x);
		x.setRequisito(this);
	}

	public void removeTarefa(Tarefa x){
		this.tarefas.remove(x);
	}

	@Override
	public String toString() {
		return "Requisito [codRequisito=" + codRequisito + ", descricao=" + descricao + ", horasPrevistas="
				+ horasPrevistas + ", custo=" + custo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codRequisito == null) ? 0 : codRequisito.hashCode());
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
		Requisito other = (Requisito) obj;
		if (codRequisito == null) {
			if (other.codRequisito != null)
				return false;
		} else if (!codRequisito.equals(other.codRequisito))
			return false;
		return true;
	}

	public boolean extrapolado() {
		int somaHorasTarefas = 0;
		for (Tarefa x : this.getTarefas()) {
			somaHorasTarefas = somaHorasTarefas + x.getHoras();
		}
		
		if (somaHorasTarefas > this.horasPrevistas) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
