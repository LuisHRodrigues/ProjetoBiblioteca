

public class Livro extends Obra {
    private String editora;
    private int edicao;
    private int numeroDeFolhas;
    private boolean emprestimo;
    
    public Livro() {
    	super();
    	this.editora = "";
    	this.edicao = 0;
    	this.numeroDeFolhas = 0;
    	this.emprestimo = false;
    }

    public Livro(String titulo, String autor, int ano, String area, String editora, int edicao, int numeroDeFolhas) {
        super(titulo, autor, ano, area);
        this.editora = editora;
        this.edicao = edicao;
        this.numeroDeFolhas = numeroDeFolhas;
        this.emprestimo = false;
    }
   

    public String getEditora() {
        return editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getNumeroDeFolhas() {
        return numeroDeFolhas;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public void setNumeroDeFolhas(int numeroDeFolhas) {
        this.numeroDeFolhas = numeroDeFolhas;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    // Métodos abrir e fechar livro
    public void abrirLivro() {
        System.out.println("O livro está aberto para leitura.");
    }

    public void fecharLivro() {
        System.out.println("O livro está fechado.");
    }
    
    @Override
	public void acessarObra() {
		abrirLivro();
    }

	@Override
	public String toString() {
		return "Livro [editora=" + editora + ", edicao=" + edicao + ", numeroDeFolhas=" + numeroDeFolhas
				+ ", emprestimo=" + emprestimo + ", Titulo=" + getTitulo() + ", Autor=" + getAutor()
				+ ", Ano=" + getAno() + ", Area=" + getArea() + "]";
	}

	
}
