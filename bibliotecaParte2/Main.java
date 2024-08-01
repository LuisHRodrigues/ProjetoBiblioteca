import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ABSOLUTE_PATH = "C:\\biblioteca_dados";
    private static final String USUARIOS_FILE = ABSOLUTE_PATH + "\\usuarios.txt";
    private static final String LIVROS_FILE = ABSOLUTE_PATH + "\\livros.txt";
    private static final String EMPRESTIMOS_FILE = ABSOLUTE_PATH + "\\emprestimos.txt";

    public static void main(String[] args) {
        inicializarDados();
        int opcao = 0;
        Scanner text = new Scanner(System.in);

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Realizar devolução");
            System.out.println("5. Listar todos os empréstimos");
            System.out.println("6. Sair");
            System.out.println("7. Listar usuários");
            System.out.println("8. Listar livros");
            System.out.print("Escolha uma opção: ");
            opcao = text.nextInt();
            text.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro(text);
                    break;
                case 2:
                    cadastrarUsuario(text);
                    break;
                case 3:
                    realizarEmprestimo(text);
                    break;
                case 4:
                    realizarDevolucao(text);
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

        text.close();
    }
    private static void inicializarDados() {
        // Adicionar usuários
        salvarDados(USUARIOS_FILE, "Nome: João Silva, Idade: 30, Sexo: Masculino, Telefone: 123456789");
        salvarDados(USUARIOS_FILE, "Nome: Maria Oliveira, Idade: 25, Sexo: Feminino, Telefone: 987654321");

        // Adicionar livros
        salvarDados(LIVROS_FILE, "Titulo: Programação Java, Autor: João Silva, Area: Tecnologia, Editora: Fundo de quintal, Ano: 2020, Numero de Folhas: 300");
        salvarDados(LIVROS_FILE, "Titulo: Estruturas de Dados, Autor: Ana Costa, Area: Tecnologia, Editora: Danilois, Ano: 2019, Numero de Folhas: 450");

        // Adicionar empréstimos
        String dataEmprestimo = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaEmprestimo = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        salvarDados(EMPRESTIMOS_FILE, "Data: " + dataEmprestimo + ", Hora: " + horaEmprestimo + ", Livro: Programação Java, Usuario: João Silva");
    }


    private static void salvarDados(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> lerDados(String fileName) {
        try {
            return Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void listarLivros() {
        List<String> livros = lerDados(LIVROS_FILE);
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        } else {
            for (String livro : livros) {
                System.out.println(livro);
            }
        }
    }

    private static void listarUsuarios() {
        List<String> usuarios = lerDados(USUARIOS_FILE);
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            for (String usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void listarEmprestimos() {
        List<String> emprestimos = lerDados(EMPRESTIMOS_FILE);
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo encontrado.");
        } else {
            for (String emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    private static void realizarDevolucao(Scanner text) {
        System.out.println("Livro a ser devolvido: ");
        String titulo = text.nextLine();

        List<String> emprestimos = lerDados(EMPRESTIMOS_FILE);
        List<String> novosEmprestimos = new ArrayList<>();

        boolean found = false;
        for (String emprestimo : emprestimos) {
            if (emprestimo.contains("Livro: " + titulo)) {
                found = true;
            } else {
                novosEmprestimos.add(emprestimo);
            }
        }

        if (found) {
            try {
                Files.write(Paths.get(EMPRESTIMOS_FILE), novosEmprestimos, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("O livro \"" + titulo + "\" foi devolvido com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("O livro \"" + titulo + "\" não foi encontrado nos empréstimos.");
        }
    }

    private static void realizarEmprestimo(Scanner text) {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = text.nextLine();

        System.out.print("Título do livro: ");
        String tituloLivro = text.nextLine();

        List<String> usuarios = lerDados(USUARIOS_FILE);
        List<String> livros = lerDados(LIVROS_FILE);

        boolean usuarioEncontrado = false;
        boolean livroEncontrado = false;

        for (String usuario : usuarios) {
            if (usuario.contains("Nome: " + nomeUsuario)) {
                usuarioEncontrado = true;
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        for (String livro : livros) {
            if (livro.contains("Titulo: " + tituloLivro)) {
                livroEncontrado = true;
                break;
            }
        }

        if (!livroEncontrado) {
            System.out.println("Livro não encontrado.");
            return;
        }

        // Verificar se o livro já está emprestado
        List<String> emprestimos = lerDados(EMPRESTIMOS_FILE);
        for (String emprestimo : emprestimos) {
            if (emprestimo.contains("Livro: " + tituloLivro)) {
                System.out.println("Livro já está emprestado.");
                return;
            }
        }

        // Obter data e hora atuais
        String dataEmprestimo = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaEmprestimo = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

        // Realizar o empréstimo
        String novoEmprestimo = "Data: " + dataEmprestimo + ", Hora: " + horaEmprestimo + ", Livro: " + tituloLivro + ", Usuario: " + nomeUsuario;
        salvarDados(EMPRESTIMOS_FILE, novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + novoEmprestimo);
    }

    private static void cadastrarUsuario(Scanner text) {
        System.out.print("Nome do usuario: ");
        String nome = text.nextLine();

        System.out.print("Idade do usuario: ");
        int idade = text.nextInt();
        text.nextLine();

        System.out.print("Sexo do usuario: ");
        String sexo = text.nextLine();

        System.out.print("Telefone do usuario: ");
        String telefone = text.nextLine();

        String usuario = "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo + ", Telefone: " + telefone;
        salvarDados(USUARIOS_FILE, usuario);
        System.out.println("Usuario cadastrado com sucesso!");
    }

    private static void cadastrarLivro(Scanner text) {
        System.out.print("Titulo do livro: ");
        String titulo = text.nextLine();

        System.out.print("Nome do(s) autor(es): ");
        String autores = text.nextLine();

        System.out.print("Area do livro: ");
        String area = text.nextLine();

        System.out.print("Editora do livro: ");
        String editora = text.nextLine();

        System.out.print("Ano de publicação do livro: ");
        int ano = text.nextInt();
        text.nextLine();

        System.out.print("Numero de folhas do livro: ");
        int numFolhas = text.nextInt();
        text.nextLine();


        String livro = "Titulo: " + titulo + ", Autor: " + autores + ", Area: " + area + ", Editora: " + editora + ", Ano: " + ano + ", Numero de Folhas: " + numFolhas;
        salvarDados(LIVROS_FILE, livro);
        System.out.println("Livro cadastrado com sucesso!");
    }
}
