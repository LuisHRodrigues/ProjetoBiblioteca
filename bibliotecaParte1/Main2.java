package bibliotecaParte1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main2 {
	public static final ArrayList<Livro> livros = new ArrayList<>();
	public static final ArrayList<Usuario> usuarios = new ArrayList<>();
	public static final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
	public static final Scanner text = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;
		do {
			System.out.println("Menu:");
			System.out.println("1. Cadastrar livro");
			System.out.println("2. Cadastrar usuário");
			System.out.println("3. Realizar empréstimo");
			System.out.println("4. Realizar devolução");
			System.out.println("5. Listar todos os empréstimos");
			System.out.println("6. Sair");
			System.out.println("7. Listar usuarios");
			System.out.println("8. Listas livros");
			System.out.print("Escolha uma opção: ");
			Scanner text = new Scanner(System.in);
			opcao = text.nextInt();
			text.nextLine();

			switch (opcao) {
			case 1:
				cadastrarLivro();
				break;
			case 2:
				cadastrarUsuario();
				break;
			case 3:
				realizarEmprestimo();
				break;
			case 4:
				realizarDevolucao();
				break;
			case 5:
				listarEmprestimos();
				break;
			case 6:
				System.out.println("Saindo...");
				break;
			case 7:
				listarUsuarios();
				break;
			case 8:
				listarLivros();
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 6);
	}

	private static void listarLivros() {
		if (livros.isEmpty()) {
			System.out.println("Nenhum livro encontrado.");
		} else {
			for (Livro livro : livros) {
				System.out.println(livro);
			}
		}

	}

	private static void listarUsuarios() {
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuário encontrado.");
		} else {
			for (Usuario usuario : usuarios) {
				System.out.println(usuario);
			}
		}

	}

	private static void listarEmprestimos() {
		if (emprestimos.isEmpty()) {
			System.out.println("Nenhum empréstimo encontrado.");
		} else {
			for (Emprestimo emprestimo : emprestimos) {
				System.out.println(emprestimo);
			}
		}
	}

	private static void realizarDevolucao() {

		System.out.println("Livro a ser devolvido: ");
		String titulo = text.nextLine();

		// Verifica se a lista de empréstimos está vazia ou nula
		if (emprestimos == null || emprestimos.isEmpty()) {
			System.out.println("Não há empréstimos para devolver.");
			return;
		}

		Iterator<Emprestimo> iterator = emprestimos.iterator();
		while (iterator.hasNext()) {
			Emprestimo e = iterator.next();
			if (e.getLivro().getTitulo().equals(titulo)) {
				iterator.remove();
				System.out.println("O livro \"" + titulo + "\" foi devolvido com sucesso.");
				return;
			}
		}

		System.out.println("O livro \"" + titulo + "\" não foi encontrado nos empréstimos.");
	}

	public static void realizarEmprestimo() {
		Scanner text = new Scanner(System.in);

        System.out.print("Nome do usuário: ");
        String nomeUsuario = text.nextLine();

        System.out.print("Título do livro: ");
        String tituloLivro = text.nextLine();

        Usuario usuario = null;
        Livro livro = null;

        // Encontrar o usuário pelo nome
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuario = u;
                break;
            }
        }

        // Verificar se o usuário foi encontrado
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        // Encontrar o livro pelo título
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livro = l;
                break;
            }
        }

        // Verificar se o livro foi encontrado
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        // Verificar se o livro já está emprestado
        for (Emprestimo e : emprestimos) {
            if (e.getLivro().equals(livro)) {
                System.out.println("Livro já está emprestado.");
                return;
            }
        }

        // Obter data e hora atuais
        String dataEmprestimo = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaEmprestimo = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

        // Realizar o empréstimo
        Emprestimo novoEmprestimo = new Emprestimo(dataEmprestimo, horaEmprestimo,livro,usuario);
        adicionarEmprestimo(novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + novoEmprestimo);
    }

	 public static void adicionarEmprestimo(Emprestimo emprestimo) {
	        emprestimos.add(emprestimo);
	    }

	private static void cadastrarUsuario() {

		// Objeto
		Usuario usu = new Usuario();

		Scanner text = new Scanner(System.in);
		System.out.print("Nome do usuario: ");
		String usuario = text.nextLine();
		usu.setNome(usuario);

		text = new Scanner(System.in);

		System.out.print("Idade do usuario: ");
		int idade = text.nextInt();
		usu.setIdade(idade);

		text = new Scanner(System.in);

		System.out.print("Sexo do usuario: ");
		String sexo = text.nextLine();
		usu.setSexo(sexo);

		System.out.print("Telefone do usuario: ");
		String telefone = text.nextLine();
		usu.setTelefone(telefone);

		usuarios.add(usu);
		System.out.print("Usuario cadastrado com sucesso!");

	}

	private static void cadastrarLivro() {
		// Objeto
		Livro lv = new Livro();

		System.out.print("Titulo do livro: ");
		String titulo = text.nextLine();
		lv.setTitulo(titulo);

		System.out.print("Nome do(s) autor(es): ");
		String autores = text.nextLine();
		lv.setAutor(autores);

		System.out.print("Area do livro: ");
		String area = text.nextLine();
		lv.setArea(area);

		System.out.print("Editora do livro: ");
		String editora = text.nextLine();
		lv.setEditora(editora);

		System.out.print("Ano de publicação do livro: ");
		int ano = text.nextInt();
		lv.setAno(ano);

		System.out.print("Numero de folhas do livro: ");
		int NumFolhas = text.nextInt();
		lv.setNumeroDeFolhas(NumFolhas);

		livros.add(lv);
		System.out.println("Livro cadastrado com sucesso!");

	}

	private static Livro encontrarLivro(String titulo, ArrayList<Livro> livros) {
		for (Livro livro : livros) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) { // Usar equals ou equalsIgnoreCase para comparar strings
				return livro;
			}
		}
		return null;
	}

	private static Usuario encontrarUsuario(String nome, ArrayList<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nome)) {
				return usuario;
			}
		}
		return null;
	}

}
