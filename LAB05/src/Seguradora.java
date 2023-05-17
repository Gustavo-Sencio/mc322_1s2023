import java.util.*;

public class Seguradora {
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Seguro> listaSeguros;
    private List<Cliente> listaClientes;
    
    public Seguradora(String CNPJ, String nome, String telefone, String email, String endereco,
            List<Seguro> listaSeguros, List<Cliente> listaClientes) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSeguros = listaSeguros;
        this.listaClientes = listaClientes;
    }

    //Getters e setters
    public String getCNPJ() {
        return CNPJ;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(List<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    //Outros métodos
    @Override
    public String toString() {
        return "Seguradora [CNPJ=" + CNPJ + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
                + ", endereco=" + endereco + ", listaSeguros=" + listaSeguros + ", listaClientes=" + listaClientes
                + "]";
    }    
}
