public class Sinistro{
    private String data;
    private String endereco;
    private final int id;
    private static int id_atual = 0;
    Seguradora seguradora;
    Veiculo veiculo;
    Cliente cliente;

    //Construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
        this.id = id_atual;

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
    
}