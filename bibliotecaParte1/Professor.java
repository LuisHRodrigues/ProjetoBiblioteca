package bibliotecaParte1;

public class Professor extends Funcionario {
	private String especialidade;
	private int numeroPublicacoes;

	public Professor(String nome, int idade, String sexo, String telefone, String departamento, String cargo,
			String especialidade, int numeroPublicacoes) {
		super(nome, idade, sexo, telefone, departamento, cargo);
		this.especialidade = especialidade;
		this.numeroPublicacoes = numeroPublicacoes;
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
}
