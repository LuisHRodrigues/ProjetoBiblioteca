

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.nio.*;

public class Emprestimo {

    // Máximo de obras e dias de empréstimo permitidos para estudantes
	/* public static final int MAX_OBRAS_ESTUDANTE = 3;
	 public static final int MAX_DIAS_ESTUDANTE = 7;
 
	 // Máximo de obras e dias de empréstimo permitidos para funcionários
	 public static final int MAX_OBRAS_FUNCIONARIO = 6;
	 public static final int MAX_DIAS_FUNCIONARIO = 15;
 
	 // Máximo de obras e dias de empréstimo permitidos para professores
	 public static final int MAX_OBRAS_PROFESSOR = 9;
	 public static final int MAX_DIAS_PROFESSOR = 30;
 */
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
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

    public void regrasDeEmprestimo(String nomeUsuario) {
        boolean usuarioEncontrado = false;

        List<String> usuarios = Collections.singletonList((Files.getUsuariosFile()));
        String tipoUsuario = "";
        for (String usuario : usuarios) {
            if (usuario.contains("Nome: " + nomeUsuario)) {
                usuarioEncontrado = true;
                tipoUsuario = usuario.split(",")[4].split(": ")[1]; // Obtém o tipo do usuário.
                break;
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
    }

}
