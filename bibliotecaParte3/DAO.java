
import java.util.List;

public interface DAO<T> {
    void gravar(T t);
    void excluir(T t);
    T ler(int index);
    void atualizar(T t, int n);
    List<T> listarTodos();
}
