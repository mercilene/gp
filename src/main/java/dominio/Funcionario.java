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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_funcionario")
public class Funcionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codFuncionario;
	private String nome;
	private String cpf;
	private String fone;
	private String email;
	private Date nascimento;
	private BigDecimal salario;
	
	@OneToMany(mappedBy="funcionario")
	private List<Tarefa> tarefas;
	
	public Funcionario(){
		tarefas = new ArrayList<>();
	}

	public Funcionario(Integer codFuncionario, String nome, String cpf, String fone, String email, Date nascimento,
			BigDecimal salario) {
		super();
		this.codFuncionario = codFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.fone = fone;
		this.email = email;
		this.nascimento = nascimento;
		this.salario = salario;
		tarefas = new ArrayList<>();
	}

	public Integer getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(Integer codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public void addTarefa(Tarefa x){
		this.tarefas.add(x);
		x.setFuncionario(this);
	}

	public void removeTarefa(Tarefa x){
		this.tarefas.remove(x);
	}

	@Override
	public String toString() {
		return "Funcionario [codFuncionario=" + codFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", fone=" + fone+ ", email=" + email
				+ ", nascimento=" + nascimento + ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFuncionario == null) ? 0 : codFuncionario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (codFuncionario == null) {
			if (other.codFuncionario != null)
				return false;
		} else if (!codFuncionario.equals(other.codFuncionario))
			return false;
		return true;
	}
	
	
}
