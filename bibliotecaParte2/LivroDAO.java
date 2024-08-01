

import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements DAO<Livro> {
    private List<Livro> livros = new ArrayList<>();

    @Override
    public void gravar(Livro livro) {
        livros.add(livro);
        System.out.println("Livro gravado com sucesso: " + livro);
    }

    @Override
    public void excluir(Livro livro) {
        livros.remove(livro);
        System.out.println("Livro excluído com sucesso: " + livro);
    }

    @Override
    public Livro ler(int id) {
        if (id >= 0 && id < livros.size()) {
            return livros.get(id);
        }
        System.out.println("Livro não encontrado para o ID: " + id);
        return null;
    }

    @Override
    public void atualizar(Livro livro) {
        int index = livros.indexOf(livro);
        if (index >= 0) {
            livros.set(index, livro);
            System.out.println("Livro atualizado com sucesso: " + livro);
        }
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(livros);
    }
}
