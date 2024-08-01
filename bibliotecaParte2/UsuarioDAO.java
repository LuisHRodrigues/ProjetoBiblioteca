

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void gravar(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário gravado com sucesso: " + usuario);
    }

    @Override
    public void excluir(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuário excluído com sucesso: " + usuario);
    }

    @Override
    public Usuario ler(int id) {
        if (id >= 0 && id < usuarios.size()) {
            return usuarios.get(id);
        }
        System.out.println("Usuário não encontrado para o ID: " + id);
        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        int index = usuarios.indexOf(usuario);
        if (index >= 0) {
            usuarios.set(index, usuario);
            System.out.println("Usuário atualizado com sucesso: " + usuario);
        }
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}
