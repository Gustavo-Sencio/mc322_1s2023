import java.util.*;

public class Seguradora {
    private final String CNPJ;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private List<Seguro> listaSeguros;
    private List<Cliente> listaClientes;
    
    public Seguradora(String CNPJ, String nome, String telefone, String email, String endereco) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listaSeguros = new ArrayList<Seguro>();
        this.listaClientes = new ArrayList<Cliente>();
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

    /*Separa os clientes por tipo de acordo com a entrada e retorna
    uma lista de clientes do tipo correspondente*/
    public List<Cliente> listarClientes(String tipoCliente){
        String pj = new String("PJ");
        List<Cliente> outlist = new ArrayList<Cliente>();

        if (tipoCliente.equals(pj)){
            for (Cliente c:getListaClientes()){
                if (c instanceof ClientePJ) //Se c é um cliente PJ
                    outlist.add(c); //Adiciona na lista de saída
            }
        } else {
            for (Cliente c:getListaClientes()){
                if (c instanceof ClientePF) //Se c é um cliente PF
                    outlist.add(c); //Adiciona na lista de saída
            }
        }
        return outlist;
    }

    public boolean cadastrarCliente(Cliente cliente){
        boolean out = true;

        for (Cliente c:listaClientes){
            if(c.equals(cliente)){
                out = false;
                break;
            }
        }

        if (out)
            listaClientes.add(cliente);
        return out;
    }

    public boolean removerCliente(String cliente){
        boolean out = false;

        for (int i = 0; i<this.listaClientes.size(); i++){
            if(this.listaClientes.get(i).getNome().equals(cliente)){ //Se o cliente está na lista
                out = true;
                this.listaClientes.remove(i); //Remova ele
                break;
            }
        }
        return out;
    }

    public List<Seguro> getSegurosporCliente(){
        
    }

    @Override
    public String toString() {
        return "Seguradora [CNPJ=" + CNPJ + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
                + ", endereco=" + endereco + ", listaSeguros=" + listaSeguros + ", listaClientes=" + listaClientes
                + "]";
    }    
}
