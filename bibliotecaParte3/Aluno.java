import java.sql.Date;

public class Aluno extends Pessoa {
	private String matricula;
	private String curso;
	private int ano;
	private long id;
	private String email;

	

	public Aluno(String nome, int idade, String sexo, String telefone, Date dataNasci, long cpf, String matricula,
			String curso, int ano, long id, String email) {
		super(nome, idade, sexo, telefone, dataNasci, cpf);
		this.matricula = matricula;
		this.curso = curso;
		this.ano = ano;
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

	public String getMatricula() {
		return matricula;
	}

	public String getCurso() {
		return curso;
	}

	public int getAno() {
		return ano;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Estudante : matricula= " + matricula + ", curso= " + curso + ", ano= " + ano + ", nome= " + getNome()
				+ ", idade=" + getIdade() + ", sexo= " + getSexo() + ", telefone=" + getTelefone() + ", id= "+id+"\n";
	}

	
	
}
