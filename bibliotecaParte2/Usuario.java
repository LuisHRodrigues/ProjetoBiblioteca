

public abstract class Usuario {
    private String nome;
    private int idade;
    private String sexo;
    private String telefone;

    public Usuario() {
        this.nome = "";
        this.idade = 0;
        this.sexo = "";
        this.telefone = "";
    }

    public Usuario(String nome, int idade, String sexo, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Metodo para informar que o usuario está lendo o livro.
    public void lerLivro() {
        System.out.println("O usuário está lendo o livro.");
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", telefone=" + telefone + "]";
    }
}
