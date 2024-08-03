

public class MidiaAudio extends Obra {
	private int duracao;
	private String formato;

	public MidiaAudio() {
		super();
		this.duracao = 0;
		this.formato = "";
	}

	public MidiaAudio(String titulo, String autor, int ano, String area, int duracao, String formato, boolean reserva) {
		super(titulo, autor, ano, area, reserva);
		this.duracao = duracao;
		this.formato = formato;
	}

	public int getDuracao() {
		return duracao;
	}

	public String getFormato() {
		return formato;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	@Override
	public void acessarObra() {
		System.out.println("Reproduzindo a mídia de audio "+ getTitulo() + "com duração de "+duracao+ " minutos e formato  "+ formato);
	}

}
