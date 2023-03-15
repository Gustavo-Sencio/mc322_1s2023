public class Sinistro{
    private String data;
    private String endereco;
    private int id;

    //Construtor
    public Sinistro(String data, String endereco){
        this.data = data;
        this.endereco = endereco;

        //gerar id
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