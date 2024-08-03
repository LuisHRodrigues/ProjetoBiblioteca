public class Reserva {
    private String dataReserva;
    private Livro livro;
    private Pessoa usuario;

    //Contrutor padão
    public Reserva(String dataReserva, Livro livro, Pessoa usuario) {
        this.dataReserva = dataReserva;
        this.livro = livro;
        this.usuario = usuario;
    }

    // Getters e Setters
    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return " Data da reserva= " + dataReserva + ", livro= " + livro + ", usuario= " + usuario;
    }
}