package bibliotecaParte1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final ArrayList<Livro> livros = new ArrayList<>();
	public static final ArrayList<Usuario> usuarios = new ArrayList<>();
	public static final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
	public static final Scanner text = new Scanner(System.in);

	public static void main(String[] args) {

		// Teste da hierarquia de classes
		Estudante estudante = new Estudante("Eneias", 20, "Masculino", "123456789", "20240001", "SI", 2);
		Professor professor = new Professor("Olavo de Carvalho", 45, "M", "987654321", "Ciências", "Professor",
				"Sociologia", 30);

		estudante.lerLivro();
		System.out.println("Nome do estudante: " + estudante.getNome());
		System.out.println("Curso do estudante: " + estudante.getCurso());

		System.out.println("Nome do professor: " + professor.getNome());
		System.out.println("Especialidade do professor: " + professor.getEspecialidade());
		System.out.println("Número de publicações do professor: " + professor.getNumeroPublicacoes());
		System.out.println();

		// Teste de emprestimo

		Livro livro = new Livro("Programação Java", " Michael Jackson", 2023, "Programação", "Disney", 3, 450);
		Usuario usuario = new Usuario("Alberth Ainsten", 30, "Masculino", "123456789");
		Emprestimo emprestimo = new Emprestimo(" ", " ", livro, usuario);

		emprestimo.getLivro().abrirLivro();
		emprestimo.getUsuario().getNome();
		System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
		System.out.println("Usuario: " + emprestimo.getUsuario().getNome());
		System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
		System.out.println("Hora do emprestimo: " + emprestimo.getHoraEmprestimo());
		emprestimo.getUsuario().lerLivro();
		emprestimo.getLivro().fecharLivro();
		emprestimo.devolverLivro();

		// Testando a hierarquia de classes com construtores sobrecarregados

		livro = new Livro("Programação Java", "Omminiman", 2023, "Programação", "Disney", 3, 450);
		Fotografia fotografia = new Fotografia("Pôr do Sol", "Bob Marley", 2021, "Natureza", "1920x1080", "PNG");
		MidiaAudio midiaAudio = new MidiaAudio("Podcast", "Dilma", 2022, "Educação", 60, "MP3");

		// Usando o polimorfismo para acessar as obras
		Obra[] obras = { livro, fotografia, midiaAudio };

		// Esse laço permite acessar todos os polimorfismos de maneira igual sem
		// precisar conhecer o tipo especifico de cada objeto
		for (Obra obra : obras) {
			obra.acessarObra();
		}
	}
}