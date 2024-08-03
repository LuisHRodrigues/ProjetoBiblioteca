import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements DAO<Reserva> {
    private List<Reserva> reservas = new ArrayList<>();

    @Override
    public void gravar(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva gravada: " + reserva);
    }

    @Override
    public void excluir(Reserva reserva) {
        reservas.remove(reserva);
        System.out.println("Reserva excluída: " + reserva);
    }

    @Override
    public Reserva ler(int x) {
        if (x >= 0 && x < reservas.size()) {
            return reservas.get(x);
        }
        return null;
    }

    @Override
    public void atualizar(Reserva reserva, int n) {
        if (reserva == null) {
            System.out.println("Reserva fornecida é nula.");
            return;
        }

        if (n < 0 || n >= reservas.size()) {
            System.out.println("Índice fora dos limites.");
            return;
        }

        reservas.set(n, reserva);
        System.out.println("Reserva atualizada: " + reserva);
    }

    @Override
    public List<Reserva> listarTodos() {
        return reservas;
    }
}