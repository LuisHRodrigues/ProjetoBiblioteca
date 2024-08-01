
import java.util.List;

public interface DAO<T> {
    void gravar(T t);
    void excluir(T t);
    T ler(int id);
    void atualizar(T t);
    List<T> listarTodos();
}
