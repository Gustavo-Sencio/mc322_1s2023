public class Sinistro{
    private String data;
    private String endereco;
    private final int id;
    private static int id_atual = 0;
    Seguradora seguradora;
    Veiculo veiculo;
    Cliente cliente;

    //Construtores
    public Sinistro(Cliente cliente, Veiculo veiculo){
        this.seguradora = new Seguradora();
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.id = id_atual;

        //Somando o id para nunca existirem dois id's iguais
        id_atual++;
    }


    public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.data = data;
        this.endereco = endereco;
        this.id = id_atual;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;

        //Somando o id para nunca existirem dois id's iguais
        id_atual++;
    }

    //Getters e setters
    public String getData(){
        return this.data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public int getId(){
        return this.id;
    }

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }

    public Veiculo getVeiculo(){
        return this.veiculo;
    }
    
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public Seguradora getSeguradora(){
        return this.seguradora;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
    
    public String toString(){
        String out = "";
        out += "Data: "+getData()+
        "\nEndereco: "+getEndereco()+
        "\nSeguradora: "+seguradora.toString()+
        "\nVeiculo: "+veiculo.toString()+
        "\nCliente: "+cliente.toString();
        return out;
    }
}