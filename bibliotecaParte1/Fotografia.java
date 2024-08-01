package bibliotecaParte1;

public class Fotografia extends Obra {
	private String resolucao;
	private String formato;
	
	public Fotografia() {
		super();
		this.resolucao = "";
		this.formato = "";
	}

	public Fotografia(String titulo, String autor, int ano, String area, String resolucao, String formato) {
		super(titulo, autor, ano, area);
		this.resolucao = resolucao;
		this.formato = formato;
	}
	

	public String getResolucao() {
		return resolucao;
	}

	public String getFormato() {
		return formato;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
	@Override
	public void acessarObra() {
        System.out.println("Visualizando a fotografia: " + getTitulo() + " com resolução " + resolucao + " e formato " + formato);
	}
}
