import java.sql.Date;

public class Funcionario extends Pessoa {
	private String departamento;
	private String cargo;

	public Funcionario() {
		this.departamento= "";
		this.cargo = "";
	}
	

	public Funcionario(String nome, int idade, String sexo, String telefone, Date dataNasci, long cpf,
			String departamento, String cargo) {
		super(nome, idade, sexo, telefone, dataNasci, cpf);
		this.departamento = departamento;
		this.cargo = cargo;
	}


	public String getDepartamento() {
		return departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Funcionario: departamento= " + departamento + ", cargo= " + cargo + ", nome= " + getNome() + ", idade= "
				+ getIdade() + ", sexo= " + getSexo() + ", telefone= " + getTelefone() + "\n";
	}
	
}
