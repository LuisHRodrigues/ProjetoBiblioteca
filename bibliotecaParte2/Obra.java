

public abstract class Obra {
    private String titulo;
    private String autor;
    private int ano;
    private String area;

    public Obra() {
        this.titulo = "";
        this.autor = "";
        this.ano = 0;
        this.area = "";
    }

    public Obra(String titulo, String autor, int ano, String area) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.area = area;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public String getArea() {
        return area;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void acessarObra() {
        System.out.println("Acessando a obra: " + titulo);
    }
}
