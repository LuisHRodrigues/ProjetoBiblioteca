import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Files.write;

public class Main {

    /*
        private static final String ABSOLUTE_PATH = "C:\\biblioteca_dados";
        public static final String USUARIOS_FILE = ABSOLUTE_PATH + "\\usuarios.txt";
        private static final String OBRA_FILE = ABSOLUTE_PATH + "\\livros.txt";
        private static final String EMPRESTIMOS_FILE = ABSOLUTE_PATH + "\\emprestimos.txt";
        private static final String RESERVAS_FILE = ABSOLUTE_PATH + "\\reservas.txt";
    */
    public static void main(String[] args) {
        // Esse trecho garante que o diretório especificado por (ABSOLUTE_PATH) esteja
        // presente no sistema de arquivos antes de tentar criar ou escrever arquivos
        // dentro dele.
        File dir = new File(files.getAbsolutePath());
        if (!dir.exists()) {
            dir.mkdirs();
        }

        inicializarDados();

        int opcao = 0;
        Scanner text = new Scanner(System.in);

        do {
            System.out.print("""
                     =============Menu=============
                     1. Cadastrar obra
                     2. Cadastrar usuário
                     3. Realizar empréstimo
                     4. Realizar devolução
                     5. Realizar reserva
                     6. Listar todos os empréstimos
                     7. Listar todas as reservas
                     8. Listar usuários
                     9. Listar livros
                     10. Sair
                     =============================
                    """);

            opcao = text.nextInt();
            text.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarObra(text);
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
                    listarObras();
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
        //Files files = new Files();
        // Dados pré-configurados
        salvarDados(Files.getUsuariosFile(), "Nome: João, Idade: 25, Sexo: Masculino, Telefone: 123456789, Tipo: Estudante");
        salvarDados(Files.getUsuariosFile(), "Nome: Maria, Idade: 30, Sexo: Feminino, Telefone: 987654321, Tipo: Funcionário");
        salvarDados(Files.getUsuariosFile(), "Nome: Carlos, Idade: 45, Sexo: Masculino, Telefone: 112233445, Tipo: Professor");
        salvarDados(Files.getObraFile(),
                "Título: O Senhor dos Papeis, Autor: J.R.R. Tolkien, Ano: 1954, Área: Fantasia, Editora: Martins Fontes, Número de Folhas: 1200, Digital: false");
        salvarDados(Files.getObraFile(),
                "Título: O Hobbit, Autor: J.R.R. Tolkien, Ano: 1937, Área: Fantasia, Editora: Martins Fontes, Número de Folhas: 310, Digital: true");
        salvarDados(Files.getEmprestimosFile(),
                "Data: 01/01/2024, Hora: 10:00, Obra: O Senhor dos Anéis, Usuario: João, Tipo: Estudante");
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
            return readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void listarObras() {
        List<String> obras = lerDados(Files.getObraFile());
        if (obras.isEmpty()) {
            System.out.println("Nenhuma obra encontrada.");
        } else {
            for (String obra : obras) {
                System.out.println(obra);
            }
        }
    }

    private static void listarUsuarios() {
        List<String> usuarios = lerDados(Files.getUsuariosFile());
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado.");
        } else {
            for (String usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void listarEmprestimos() {
        List<String> emprestimos = lerDados(Files.getEmprestimosFile());
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo encontrado.");
        } else {
            for (String emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }

    private static void listarReservas() {
        List<String> reservas = lerDados(Files.getReservasFile());
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (String reserva : reservas) {
                System.out.println(reserva);
            }
        }
    }

    private static void realizarDevolucao(Scanner text) {
        System.out.println("Obra a ser devolvida: ");
        String titulo = text.nextLine();

        List<String> emprestimos = lerDados(Files.getEmprestimosFile());
        List<String> novosEmprestimos = new ArrayList<>();

        boolean found = false;
        for (String emprestimo : emprestimos) {
            if (emprestimo.contains("Obra: " + titulo)) {
                found = true;
            } else {
                novosEmprestimos.add(emprestimo);
            }
        }
        // Se a obra foi encontrado nos empréstimos, ele é removido da lista e o
        // arquivo é atualizado.
        if (found) {
            try {
                write(Paths.get(Files.getEmprestimosFile()), novosEmprestimos, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("A obra \"" + titulo + "\" foi devolvida com sucesso.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("A obra \"" + titulo + "\" não foi encontrada nos empréstimos.");
        }
    }

    private static void realizarEmprestimo(Scanner text) {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = text.nextLine();

        System.out.print("Título da obra: ");
        String tituloObra = text.nextLine();

        // usados para ler dados de dois arquivos de texto: um que armazena informações
        // sobre usuários (USUARIOS_FILE) e outro que armazena informações sobre obra
        // (OBRA_FILE).
        List<String> usuarios = lerDados(Files.getUsuariosFile());
        List<String> obra = lerDados(Files.getObraFile());

        boolean usuarioEncontrado = false;
        boolean obraEncontrada = false;

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

        for (String obras : obra) {
            if (obra.contains("Título: " + tituloObra)) {
                obraEncontrada = true;
                break;
            }
        }

        if (!obraEncontrada) {
            System.out.println("Obra não encontrada.");
            return;
        }

        // Verificar se o livro já está emprestado
        List<String> emprestimos = lerDados(Files.getEmprestimosFile());
        for (String emprestimo : emprestimos) {
            if (emprestimo.contains("Obra: " + tituloObra)) {
                System.out.println("Obra já foi emprestada.");
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
                + horaEmprestimo + ", Obra: " + tituloObra + ", Usuario: " + nomeUsuario + ", Tipo: " + tipoUsuario;
        salvarDados(Files.getEmprestimosFile(), novoEmprestimo);
        System.out.println("Empréstimo realizado com sucesso: " + novoEmprestimo);
    }

    private static void realizarReserva(Scanner text) {
        System.out.print("Nome do usuário: ");
        String nomeUsuario = text.nextLine();

        System.out.print("Título da obra: ");
        String tituloObra = text.nextLine();

        List<String> usuarios = lerDados(Files.getUsuariosFile());
        List<String> obras = lerDados(Files.getObraFile());

        boolean usuarioEncontrado = false;
        boolean obraEncontrada = false;
        boolean obraEmprestada = false;

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

        for (String obra : obras) {
            if (obra.contains("Título: " + tituloObra)) {
                obraEncontrada = true;
                // Verificar se o livro é digital
                if (!obra.contains("Digital: true")) {
                    obraEmprestada = true;
                }
                break;
            }
        }

        if (!obraEncontrada) {
            System.out.println("Obra não encontrada.");
            return;
        }

        // Verificar se o livro já está emprestado
        List<String> emprestimos = lerDados(Files.getEmprestimosFile());
        for (String emprestimo : emprestimos) {
            if (emprestimo.contains("Obra: " + tituloObra)) {
                obraEmprestada = true;
                break;
            }
        }

        if (!obraEmprestada) {
            System.out.println("A obra \"" + tituloObra + "\" não está emprestada e não pode ser reservada.");
            return;
        }

        // Obter data de reserva
        String dataReserva = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Realizar a reserva
        String novaReserva = "Data: " + dataReserva + ", Obra: " + tituloObra + ", Usuario: " + nomeUsuario;
        salvarDados(Files.getReservasFile(), novaReserva);
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
        salvarDados(Files.getUsuariosFile(), usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void cadastrarObra(Scanner text) {
        String obra = "";
        
        int option = 0;

        do {
            System.out.print("""
                ============Cadastrar Obra============
                1. Midia audio
                2. Fotografia
                3. Livro
                4. Cancelar
                ======================================
                """);

            option = text.nextInt();
            text.nextLine();

            if (option == 1 || option == 2 || option == 3) {
                System.out.print("Título: ");
                String titulo = text.nextLine();

                System.out.print("Nome(s) autor(es): ");
                String autores = text.nextLine();

                System.out.print("Área: ");
                String area = text.nextLine();

                System.out.print("Ano: ");
                int ano = text.nextInt();
                text.nextLine();

                System.out.print("Está disponível digitalmente? (true/false): ");
                boolean digital = text.nextBoolean();
                text.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Formato: ");
                        String formato = text.nextLine();

                        System.out.print("Duração: ");
                        int duracao = text.nextInt();

                        obra = ("Título: " + titulo + ", Autor: " + autores + ", Formato: " + formato +  ", Duração: " + duracao + ", Ano: " + ano + ", Área: " + area +
                                "Digital: " + digital);



                        break;
                    case 2:
                        System.out.print("Editora do livro: ");
                        String editora = text.nextLine();

                        System.out.print("Número de folhas do livro: ");
                        int numFolhas = text.nextInt();
                        text.nextLine();

                        obra = "Título: " + titulo + ", Autor: " + autores + ", Ano: " + ano + ", Área: " + area + ", Editora: "
                                + editora + ", Número de Folhas: " + numFolhas + ", Digital: " + digital;
                        break;
                    case 3:
                        System.out.print("Resolução da imagem: ");
                        String resolucao = text.nextLine();

                        System.out.print("Formato da imagem: ");
                        String form = text.nextLine();

                        obra = "Título: " + titulo + ", Autor: " + autores + ", Formato: " + form +
                                 ", Ano: " + ano + ", Área: " + area + ", Digital";
                        break;
                }
                }
                if (option > 3 || option < 1 ) {
                    switch (option) {
                        case 4:
                            System.out.println("Cancelando.......");
                            break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            }  while (option != 4);
        




        if (option == 2) {


        } //Livro

        if (option == 3) {

            System.out.print("Resolução da imagem: ");
            String resolucao = text.nextLine();

            System.out.print("Formato da image: ");
            String formato = text.nextLine();

            obra = "Título: " + titulo + ", Autor: " + autores + ", Formato: " + formato +
                    ", Formato: " + formato + ", Ano: " + ano + ", Área: " + area + ", Digital: " + digital;
        } //Fotografia

        salvarDados(OBRA_FILE, obra);
        System.out.println("Obra cadastrada com sucesso!");
    }

}

/*
    * Empréstimos para estudantes: até 3 livros, por até 7 dias
      Empréstimos para funcionários: até 6 livros, por até 15 dias
      Empréstimos para professores: até 9 livros, por até 30 dias.
      * */
