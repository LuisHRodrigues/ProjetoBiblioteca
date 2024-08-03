import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static final String ABSOLUTE_PATH = "C:\\biblioteca_dados";
    private static final String USUARIOS_FILE = ABSOLUTE_PATH + "\\usuarios.txt";
    private static final String LIVROS_FILE = ABSOLUTE_PATH + "\\livros.txt";
    private static final String EMPRESTIMOS_FILE = ABSOLUTE_PATH + "\\emprestimos.txt";
    private static final String RESERVAS_FILE = ABSOLUTE_PATH + "\\reservas.txt";

    public static void main(String[] args) {
        // Esse trecho garante que o diretório especificado por (ABSOLUTE_PATH) esteja
        // presente no sistema de arquivos antes de tentar criar ou escrever arquivos
        // dentro dele.
        File dir = new File(ABSOLUTE_PATH);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        inicializarDados();

        int opcao = 0;
        Scanner text = new Scanner(System.in);

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Realizar empréstimo");
            System.out.println("4. Realizar devolução");
            System.out.println("5. Realizar reserva");
            System.out.println("6. Listar todos os empréstimos");
            System.out.println("7. Listar todas as reservas");
            System.out.println("8. Listar usuários");
            System.out.println("9. Listar livros");
            System.out.println("10. Sair");
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
                    realizarReserva(text);
                    break;
                case 6:
                    listarEmprestimos();
                    break;
                case 7:
                    listarReservas();
                    break;
                case 8:
                    listarUsuarios();
                    break;
                case 9:
                    listarLivros();
                    break;
                case 10:
                    System.out.println("Saindo.......");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 10);

        text.close();
    }

    private static void inicializarDados() {
        // Dados pré-configurados
        salvarDados(USUARIOS_FILE, "Nome: João, Idade: 25, Sexo: Masculino, Telefone: 123456789, Tipo: Estudante");
        salvarDados(USUARIOS_FILE, "Nome: Maria, Idade: 30, Sexo: Feminino, Telefone: 987654321, Tipo: Funcionário");
        salvarDados(USUARIOS_FILE, "Nome: Carlos, Idade: 45, Sexo: Masculino, Telefone: 112233445, Tipo: Professor");
        salvarDados(LIVROS_FILE,
                "Título: O Senhor dos Aneis, Autor: J.R.R. Tolkien, Ano: 1954, Área: Fantasia, Editora: Martins Fontes, Número de Folhas: 1200, Digital: false");
        salvarDados(LIVROS_FILE,
                "Título: O Hobbit, Autor: J.R.R. Tolkien, Ano: 1937, Área: Fantasia, Editora: Martins Fontes, Número de Folhas: 310, Digital: true");
        salvarDados(EMPRESTIMOS_FILE,
                "Data: 01/01/2024, Hora: 10:00, Livro: O Senhor dos Anéis, Usuario: João, Tipo: Estudante");
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

    private static void listarReservas() {
        List<String> reservas = lerDados(RESERVAS_FILE);
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (String reserva : reservas) {
                System.out.println(reserva);
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
        // Se o livro foi encontrado nos empréstimos, ele é removido da lista e o
        // arquivo é atualizado.
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

        // usados para ler dados de dois arquivos de texto: um que armazena informações
        // sobre usuários (USUARIOS_FILE) e outro que armazena informações sobre livros
        // (LIVROS_FILE).
        List<String> usuarios = lerDados(USUARIOS_FILE);
        List<String> livros = lerDados(LIVROS_FILE);

        boolean usuarioEncontrado = false;
        boolean livroEncontrado = false;

        // Este trecho de código procura um usuário específico na lista que se basea no
        // nome. Quando o usuário é encontrado, o tipo de usuário (por exemplo,
        // "Estudante", "Funcionário") é
        // pega da string de dados do usuário e armazenado na variável tipoUsuario.
        String tipoUsuario = "";
        for (String usuario : usuarios) {
            if (usuario.contains("Nome: " + nomeUsuario)) {
                usuarioEncontrado = true;
                tipoUsuario = usuario.split(",")[4].split(": ")[1]; // Obtém o tipo do usuário
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        for (String livro : livros) {
            if (livro.contains("Título: " + tituloLivro)) {
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

        // Definir limites de empréstimo baseados no tipo de usuário
        int limiteObras = 0;
        int prazoDias = 0;
        switch (tipoUsuario) {
            case "Estudante":
                limiteObras = 3;
                prazoDias = 7;
                break;
            case "Funcionário":
                limiteObras = 6;
                prazoDias = 15;
                break;
            case "Professor":
                limiteObras = 9;
                prazoDias = 30;
                break;
            default:
                System.out.println("Tipo de usuário inválido.");
                return;
        }

        // Verificar quantidade de livros emprestados pelo usuário
        long totalEmprestimos = emprestimos.stream().filter(e -> e.contains("Usuário: " + nomeUsuario)).count();
        if (totalEmprestimos >= limiteObras) {
            System.out.println("Limite de empréstimos alcançado.");
            return;
        }

        // Obter data e hora atuais
        String dataEmprestimo = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dataDevolucao = LocalDate.now().plusDays(prazoDias).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String horaEmprestimo = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));

        // Realizar o empréstimo
        String novoEmprestimo = "Data Emprestimo: " + dataEmprestimo + ", Data Devolucao: " + dataDevolucao + ", Hora: "
                + horaEmprestimo + ", Livro: " + tituloLivro + ", Usuario: " + nomeUsuario + ", Tipo: " + tipoUsuario;
        salvarDados(EMPRESTIMOS_FILE, novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + novoEmprestimo);
    }

    private static void realizarReserva(Scanner text) {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = text.nextLine();

        System.out.print("Título do livro: ");
        String tituloLivro = text.nextLine();

        List<String> usuarios = lerDados(USUARIOS_FILE);
        List<String> livros = lerDados(LIVROS_FILE);

        boolean usuarioEncontrado = false;
        boolean livroEncontrado = false;
        boolean livroEmprestado = false;

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
            if (livro.contains("Título: " + tituloLivro)) {
                livroEncontrado = true;
                // Verificar se o livro é digital
                if (!livro.contains("Digital: true")) {
                    livroEmprestado = true;
                }
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
                livroEmprestado = true;
                break;
            }
        }

        if (!livroEmprestado) {
            System.out.println("O livro \"" + tituloLivro + "\" não está emprestado e não pode ser reservado.");
            return;
        }

        // Obter data de reserva
        String dataReserva = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Realizar a reserva
        String novaReserva = "Data: " + dataReserva + ", Livro: " + tituloLivro + ", Usuario: " + nomeUsuario;
        salvarDados(RESERVAS_FILE, novaReserva);
        System.out.println("Reserva realizada com sucesso: " + novaReserva);
    }

    private static void cadastrarUsuario(Scanner text) {
        System.out.print("Nome do usuário: ");
        String nome = text.nextLine();

        System.out.print("Idade do usuário: ");
        int idade = text.nextInt();
        text.nextLine();

        System.out.print("Sexo do usuário: ");
        String sexo = text.nextLine();

        System.out.print("Telefone do usuário: ");
        String telefone = text.nextLine();

        System.out.print("Tipo de usuário (Estudante/Funcionário/Professor): ");
        String tipo = text.nextLine();

        String usuario = "Nome: " + nome + ", Idade: " + idade + ", Sexo: " + sexo + ", Telefone: " + telefone
                + ", Tipo: " + tipo;
        salvarDados(USUARIOS_FILE, usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void cadastrarLivro(Scanner text) {
        System.out.print("Título do livro: ");
        String titulo = text.nextLine();

        System.out.print("Nome do(s) autor(es): ");
        String autores = text.nextLine();

        System.out.print("Área do livro: ");
        String area = text.nextLine();

        System.out.print("Editora do livro: ");
        String editora = text.nextLine();

        System.out.print("Ano de publicação do livro: ");
        int ano = text.nextInt();
        text.nextLine();

        System.out.print("Número de folhas do livro: ");
        int numFolhas = text.nextInt();
        text.nextLine();

        System.out.print("O livro é digital? (true/false): ");
        boolean digital = text.nextBoolean();
        text.nextLine();

        String livro = "Título: " + titulo + ", Autor: " + autores + ", Ano: " + ano + ", Área: " + area + ", Editora: "
                + editora + ", Número de Folhas: " + numFolhas + ", Digital: " + digital;
        salvarDados(LIVROS_FILE, livro);
        System.out.println("Livro cadastrado com sucesso!");
    }
}
