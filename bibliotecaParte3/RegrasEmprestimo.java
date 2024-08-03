public class RegrasEmprestimo {

    // Máximo de obras e dias de empréstimo permitidos para estudantes
    public static final int MAX_OBRAS_ESTUDANTE = 3;
    public static final int MAX_DIAS_ESTUDANTE = 7;

    // Máximo de obras e dias de empréstimo permitidos para funcionários
    public static final int MAX_OBRAS_FUNCIONARIO = 6;
    public static final int MAX_DIAS_FUNCIONARIO = 15;

    // Máximo de obras e dias de empréstimo permitidos para professores
    public static final int MAX_OBRAS_PROFESSOR = 9;
    public static final int MAX_DIAS_PROFESSOR = 30;

    // Verifica se um usuário pode realizar um empréstimo com base no seu tipo e nas
    // regras de limite de obras e dias.
    public boolean podeEmprestar(Pessoa usuario, int quantidadeObras, int diasEmprestimo) {
        if (usuario instanceof Aluno) {
            return quantidadeObras <= MAX_OBRAS_ESTUDANTE && diasEmprestimo <= MAX_DIAS_ESTUDANTE;
        } else if (usuario instanceof Funcionario) {
            return quantidadeObras <= MAX_OBRAS_FUNCIONARIO && diasEmprestimo <= MAX_DIAS_FUNCIONARIO;
        } else if (usuario instanceof Orientador) {
            return quantidadeObras <= MAX_OBRAS_PROFESSOR && diasEmprestimo <= MAX_DIAS_PROFESSOR;
        }
        return false;
    }

    // Obtém o número máximo de obras que um usuário pode emprestar, com base no
    // tipo de usuário.
    public int obterMaximoObras(Pessoa usuario) {
        if (usuario instanceof Aluno) {
            return MAX_OBRAS_ESTUDANTE;
        } else if (usuario instanceof Funcionario) {
            return MAX_OBRAS_FUNCIONARIO;
        } else if (usuario instanceof Orientador) {
            return MAX_OBRAS_PROFESSOR;
        }
        return 0;
    }

    // Obtém o número máximo de dias que um usuário pode emprestar uma obra, com
    // base no tipo de usuário.
    public int obterMaximoDias(Pessoa usuario) {
        if (usuario instanceof Aluno) {
            return MAX_DIAS_ESTUDANTE;
        } else if (usuario instanceof Funcionario) {
            return MAX_DIAS_FUNCIONARIO;
        } else if (usuario instanceof Orientador) {
            return MAX_DIAS_PROFESSOR;
        }
        return 0;
    }
}
