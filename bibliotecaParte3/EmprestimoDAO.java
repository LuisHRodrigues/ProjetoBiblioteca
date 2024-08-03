


import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO implements DAO<Emprestimo> {
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void gravar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo gravado com sucesso: " + emprestimo);
    }

    @Override
    public void excluir(Emprestimo emprestimo) {
        emprestimos.remove(emprestimo);
        System.out.println("Empréstimo excluído com sucesso: " + emprestimo);
    }

    @Override
    public Emprestimo ler(int id) {
        if (id >= 0 && id < emprestimos.size()) {
            return emprestimos.get(id);
        }
        System.out.println("Empréstimo não encontrado para o ID: " + id);
        return null;
    }

    @Override
    public void atualizar(Emprestimo emprestimo, int n) {
        int x = emprestimos.indexOf(emprestimo);
        if (x >= 0) {
            emprestimos.set(x, emprestimo);
            System.out.println("Empréstimo atualizado com sucesso: " + emprestimo);
        }
    }

    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(emprestimos);
    }
}

