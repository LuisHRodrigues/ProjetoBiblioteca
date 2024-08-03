

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements DAO<Pessoa> {
    private List<Pessoa> usuarios = new ArrayList<>();

    @Override
    public void gravar(Pessoa usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário gravado com sucesso: " + usuario);
    }

    @Override
    public void excluir(Pessoa usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuário excluído com sucesso: " + usuario);
    }

    @Override
    public Pessoa ler(int id) {
        if (id >= 0 && id < usuarios.size()) {
            return usuarios.get(id);
        }
        System.out.println("Usuário não encontrado para o ID: " + id);
        return null;
    }

    @Override
    public void atualizar(Pessoa usuario, int n) {
        int x = usuarios.indexOf(usuario);
        if (x >= 0) {
            usuarios.set(x, usuario);
            System.out.println("Usuário atualizado com sucesso: " + usuario);
        }
    }

    @Override
    public List<Pessoa> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}
