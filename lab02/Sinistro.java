public class Sinistro{
    private String data;
    private String endereco;
    private int id;
    private static int id_atual = 1;

    //Construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;
        this.id = id_atual;
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
    
    //Precisa do metodo setId????
}