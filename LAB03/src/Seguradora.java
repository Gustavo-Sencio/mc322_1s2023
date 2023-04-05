import java.util.*;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros;
    private List<Cliente> listaClientes;

    // Construtores
    public Seguradora(){
        this.listaClientes = new ArrayList<Cliente>();
        this.listaSinistros = new ArrayList<Sinistro>();
    }

    public Seguradora(String nome, String telefone, String email, String endereco, 
                        List<Sinistro> listaSinistros, List<Cliente> listaClientes){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.listaClientes = listaClientes;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public List<Sinistro> getListaSinistros(){
        return this.listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros){
        this.listaSinistros = listaSinistros;
    }

    public List<Cliente> getListaClientes(){
        return this.listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes){
        this.listaClientes = listaClientes;
    }

    //Outros métodos
    public boolean cadastrarCliente(Cliente cliente){
        
    }

    public boolean removerCliente(String cliente){

    }

    public List<Cliente> listarClientes(String tipoCliente){

    }

    public boolean gerarSinistro(){

    }

    public boolean visualizarSinistro(String cliente){

    }

    public List<Sinistro> listarSinistos(){
        
    }

}