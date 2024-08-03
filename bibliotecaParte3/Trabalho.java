import java.util.Date;

public class Trabalho {
    private long id;
    private String titTrabalho;
    private Faculdade faculdade;
    private Date dataConclusao;
    private Aluno aluno;
    private Orientador orientador;
    private Curso curso;
    private String localArquivo;
    private int score;
    private int quantidadeVotos;

    // Construtor padrão
    public Trabalho(long id, String titTrabalho, Faculdade faculdade, Date dataConclusao, Aluno aluno, 
                    Orientador orientador, Curso curso, String localArquivo, int score, int quantidadeVotos) {
        this.id = id;
        this.titTrabalho = titTrabalho;
        this.faculdade = faculdade;
        this.dataConclusao = dataConclusao;
        this.aluno = aluno;
        this.orientador = orientador;
        this.curso = curso;
        this.localArquivo = localArquivo;
        this.score = score;
        this.quantidadeVotos = quantidadeVotos;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitTrabalho() {
        return titTrabalho;
    }

    public void setTitTrabalho(String titTrabalho) {
        this.titTrabalho = titTrabalho;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getLocalArquivo() {
        return localArquivo;
    }

    public void setLocalArquivo(String localArquivo) {
        this.localArquivo = localArquivo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public void setQuantidadeVotos(int quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }

    // Método toString para exibir informações do trabalho
    @Override
    public String toString() {
        return "Trabalho{" +
                "id=" + id +
                ", titTrabalho='" + titTrabalho + '\'' +
                ", faculdade=" + faculdade +
                ", dataConclusao=" + dataConclusao +
                ", aluno=" + aluno +
                ", orientador=" + orientador +
                ", curso=" + curso +
                ", localArquivo='" + localArquivo + '\'' +
                ", score=" + score +
                ", quantidadeVotos=" + quantidadeVotos +
                '}';
    }
}

