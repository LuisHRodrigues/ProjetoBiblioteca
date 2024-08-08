public class Reserva {
    private String dataReserva;
    private Obra obra;
    private Pessoa usuario;

    //Contrutor padão
    public Reserva(String dataReserva,Obra obra, Pessoa usuario) {
        this.dataReserva = dataReserva;
        this.usuario = usuario;
    }

    // Getters e Setters
    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public void setUsuario(Pessoa usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return " Data da reserva = " + dataReserva + ", obra = " + obra + ", usuário = " + usuario + ".";
    }
}