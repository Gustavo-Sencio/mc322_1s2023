import java.util.List;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    private List<Cliente> listaClientes = new ArrayList<Cliente>();

    // Construtor
    public Seguradora(String nome, String telefone, String email, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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