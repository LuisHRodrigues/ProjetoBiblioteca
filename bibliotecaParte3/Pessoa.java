import java.sql.Date;

public abstract class Pessoa {
    private String nome;
    private int idade;
    private String sexo;
    private String telefone;
    private long cpf;
    private Date dataNasci;

    //construtor vazio
    public Pessoa() {
        this.nome = "";
        this.idade = 0;
        this.sexo = "";
        this.telefone = "";
    }
    // Construtor padrão
    public Pessoa(String nome, int idade, String sexo, String telefone, Date dataNasci, long cpf) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataNasci = dataNasci;
    }

    //Getters e Setters
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Date getDataNasci() {
        return dataNasci;
    }

    public void setDataNasci(Date dataNasci) {
        this.dataNasci = dataNasci;
    }

    // Metodo para informar que o usuario está lendo o livro.
    public void lerLivro() {
        System.out.println("O usuário está lendo o livro.");
    }

    @Override
    public String toString() {
        return " Nome= " + nome + ", idade= " + idade + ", sexo= " + sexo + ", telefone= " + telefone + ", data de nascimento= "+dataNasci+", cpf= "+cpf+"\n";
    }
}
