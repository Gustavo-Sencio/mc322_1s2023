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
        Cliente cl;
        Seguro seg;

        for (int i = 0; i<this.listaClientes.size(); i++){
            if(this.listaClientes.get(i).getNome().equals(cliente)){ //Se o cliente está na lista
                out = true;
                cl = getListaClientes().get(i);
                this.listaClientes.remove(i); //Remova ele
                break;
            }
        }
        for (Seguro s:getListaSeguros()){
            if(s.getCliente().equals(cl)){
                seg = s;
                break
            }
        }

        boolean ver = cancelarSeguro(seg.getId());

        return out;
    }

    public boolean cancelarSeguro(int id){
        boolean out = false;

        for (int i = 0; i<getListaSeguros().size(); i++){
            if(getListaSeguros().get(i).getId() == id){
                out = true;
                this.listaSeguros.remove(i);
                break;
            }
        }

        return out;
    }

    public boolean gerarSeguro(ClientePF cliente, Veiculo veiculo){
        boolean out = false;
        for (Cliente c:getListaClientes()){ //Verificando se o cliente está na seguradora
            if (c.equals(cliente)){
                out = true;
                break;
            }
        }

        if (out){
            Calendar dataInicio = Calendar.getInstance();
            Calendar dataFim = Calendar.getInstance();
            dataFim.set(dataFim.get(Calendar.YEAR) + 10, dataFim.get(Calendar.MONTH), dataFim.get(Calendar.DAY));
            Seguro novoSeguro = new Seguro(dataInicio, dataFim, this, veiculo, cliente);
            this.listaSeguros.add(novoSeguro);
        }

        return out;
    }

    public boolean gerarSeguro(ClientePJ cliente, Frota frota){
        boolean out = false;
        for (Cliente c:getListaClientes()){ //Verificando se o cliente está na seguradora
            if (c.equals(cliente)){
                out = true;
                break;
            }
        }

        if (out){
            Calendar dataInicio = Calendar.getInstance();
            Calendar dataFim = Calendar.getInstance();
            dataFim.set(dataFim.get(Calendar.YEAR) + 10, dataFim.get(Calendar.MONTH), dataFim.get(Calendar.DAY));
            Seguro novoSeguro = new Seguro(dataInicio, dataFim, this, frota, cliente);
            this.listaSeguros.add(novoSeguro);
        }

        return out;
    }

    public List<Seguro> getSegurosPorCliente(Cliente cliente){
        List<Seguro> segurosCliente = new ArrayList<Cliente>();

        for (Seguro s:getListaSeguros()){
            if (s.getCliente().equals(cliente))
                segurosCliente.add(s);
        }

        return segurosCliente;
    }

    public List<Sinistro> getSinistrosPorCliente(Cliente cliente){
        List<Sinistro> sinistrosCliente = new ArrayList<Cliente>();
        List<Seguro> segurosCliente = getSegurosPorCliente(cliente);

        for (Seguro s:segurosCliente){
            for (Sinistro sinistro:s.getListaSinistros()){
                sinistrosCliente.add(sinistro);
            }
        }

        return sinistrosCliente;
    }

    public double calcularReceita(){
        double receita = 0;

        for (Seguro s:getListaSeguros())
            receita += s.getValorMensal();
        
        return receita;
    }

    @Override
    public String toString() {
        return "Seguradora [CNPJ=" + CNPJ + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
                + ", endereco=" + endereco + ", listaSeguros=" + listaSeguros + ", listaClientes=" + listaClientes
                + "]";
    }    
}
