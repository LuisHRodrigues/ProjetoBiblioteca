

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	private String dataEmprestimo;
	private String horaEmprestimo;
	private Livro livro;
	private Pessoa usuario;

	public Emprestimo(String dataEmprestimo, String horaEmprestimo, Livro livro, Pessoa usuario) {
		this.dataEmprestimo = dataEmprestimo;
		this.horaEmprestimo = horaEmprestimo;
		this.livro = livro;
		this.usuario = usuario;
	}
	public Emprestimo() {
		
	}
	public String getDataEmprestimo() {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dataFormatada = hoje.format(formatter);
		return dataFormatada;
	}

	public String getHoraEmprestimo() {
		LocalTime hora = LocalTime.now();
		DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("HH:mm");
		String horaFormatada = hora.format(formatter);
		return horaFormatada;
	}

	public Livro getLivro() {
		return livro;
	}

	public Pessoa getUsuario() {
		return usuario;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public void setHoraEmprestimo(String horaEmprestimo) {
		this.horaEmprestimo = horaEmprestimo;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}

	// Método devolverLivro
	public void devolverLivro() {
		livro.setEmprestimo(true);
		System.out.print("Livro devolvido.\n\n");
	}
	@Override
	public String toString() {
		return " DataEmprestimo= " + dataEmprestimo + ", horaEmprestimo= " + horaEmprestimo + "livro= "
				+ livro + ", usuario= " + usuario + "\n";
	}
	

}
