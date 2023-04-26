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
    /*Verifica se o cliente já está cadastrado, caso não
    esteja é feito o cadastro*/
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

    /*Verifica o cliente existe para remove-lo*/
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

    /*Separa os clientes por tipo de acordo com a entrada e retorna
    uma lista de clientes do tipo correspondente*/
    public List<Cliente> listarClientes(String tipoCliente){
        String pj = new String("PJ");
        List<Cliente> outlist = new ArrayList<Cliente>();

        if (tipoCliente.equals(pj)){
            for (Cliente c:listaClientes){
                if (c instanceof ClientePJ) //Se c é um cliente PJ
                    outlist.add(c); //Adiciona na lista de saída
            }
        } else {
            for (Cliente c:listaClientes){
                if (c instanceof ClientePF) //Se c é um cliente PF
                    outlist.add(c); //Adiciona na lista de saída
            }
        }

        return outlist;
    }

    /*Verifica se o sinístro já não existe, caso não exista
    cria um novo sinístro*/
    public boolean gerarSinistro(Cliente cliente, Veiculo veiculo){
        boolean out = true;

        for (Sinistro s:getListaSinistros()){
            if(s.getVeiculo().equals(veiculo) || 
               s.getCliente().equals(cliente)){
                out = false;
                break;
            }
        }

        if (out){
            Sinistro novo_s = new Sinistro(cliente, veiculo);
            getListaSinistros().add(novo_s);
        }

        return out;
    }

    /*Retorna true caso tenha conseguido imprimir o sinistro*/
    public boolean visualizarSinistro(String cliente){
        boolean out = false;

        for (int i = 0; i<this.listaSinistros.size(); i++){
            if(this.listaSinistros.get(i).getCliente().getNome().equals(cliente)){ //Se o cliente está na lista
                out = true;
                System.out.println(this.listaSinistros.get(i).toString());
            }
        }
        return out;
    }

    public List<Sinistro> listarSinistros(){
        return listaSinistros; 
    }

    public double calcularPrecoSeguroCliente(Cliente cliente){
        return 0.0;
    }

    public void calcularReceita(){
        double soma = 0.0;
        for (Cliente c:this.listaClientes){
            soma += c.getValorSeguro();
        }

        System.out.println("A receita da seguradora "+this.nome+" é: "+soma);
    }

}