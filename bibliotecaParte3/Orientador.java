import java.sql.Date;

public class Orientador extends Funcionario {
	private String especialidade;
	private int numeroPublicacoes;
	private long id;
	private String email;

	public Orientador(String nome, int idade, String sexo, String telefone, Date dataNasci, long cpf,
			String departamento, String cargo, String especialidade, int numeroPublicacoes, long id, String email) {
		super(nome, idade, sexo, telefone, dataNasci, cpf, departamento, cargo);
		this.especialidade = especialidade;
		this.numeroPublicacoes = numeroPublicacoes;
		this.id = id;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public int getNumeroPublicacoes() {
		return numeroPublicacoes;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public void setNumeroPublicacoes(int numeroPublicacoes) {
		this.numeroPublicacoes = numeroPublicacoes;
	}

	@Override
	public String toString() {
		return "Professor : especialidade= " + especialidade + ", numeroPublicacoes= " + numeroPublicacoes
				+ ", Departamento= " + getDepartamento() + ", cargo= " + getCargo() + ", nome= " + getNome()
				+ ", idade= " + getIdade() + ", sexo= " + getSexo() + ", telefone= " + getTelefone() + ", id= " + id
				+ ", email= " + email + "\n";
	}

}
