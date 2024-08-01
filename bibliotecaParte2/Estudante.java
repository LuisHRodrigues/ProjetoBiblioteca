

public class Estudante extends Usuario {
	private String matricula;
	private String curso;
	private int ano;

	public Estudante(String nome, int idade, String sexo, String telefone, String matricula, String curso, int ano) {
		super(nome, idade, sexo, telefone);
		this.matricula = matricula;
		this.curso = curso;
		this.ano = ano;
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
		return "Estudante [matricula=" + matricula + ", curso=" + curso + ", ano=" + ano + "]";
	}
	
}
