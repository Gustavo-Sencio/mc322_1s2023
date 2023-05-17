import java.util.*;

public class Condutor {
    private final String CPF;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Calendar dataNascimento;
    private List<Sinistro> listaSinistros;

    //Construtor
    public Condutor(String cPF, String nome, String telefone, String endereco, String email, Calendar dataNascimento,
            List<Sinistro> listaSinistros) {
        CPF = cPF;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.listaSinistros = listaSinistros;
    }

    //Getters e Setters
    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    //Outros métodos
    @Override
    public String toString() {
        return "Condutor [CPF=" + CPF + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
                + ", email=" + email + ", dataNascimento=" + dataNascimento + ", listaSinistros=" + listaSinistros
                + "]";
    }  
}
