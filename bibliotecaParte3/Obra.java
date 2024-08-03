public abstract class Obra {
    private String titulo;
    private String autor;
    private int ano;
    private String area;
    private boolean digital;

    public Obra() {
        this.titulo = "";
        this.autor = "";
        this.ano = 0;
        this.area = "";
        this.digital = false;
    }

    public Obra(String titulo, String autor, int ano, String area, boolean digital) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.area = area;
        this.digital = digital;
    }

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public abstract void acessarObra();
}
