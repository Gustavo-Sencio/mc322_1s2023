public class Sinistro {
    private final int id;
    private static int id_atual = 0;
    private Calendar data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;

    public Sinistro(Calendar data, String endereco, Condutor condutor, Seguro Seguro){
        this.id = id_atual;
        this.data = data;
        this.endereco = endereco;
        this.condutor = condutor;
        this.seguro = seguro;

        //Somando o id para nunca existirem dois id's iguais
        id_atual++;
    }

    //Setters e Getters
    public int getId(){
        return id;
    }

    public Calendar getData(){
        return data;
    }

    public void setData(Calendar data){
        this.data = data;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Condutor getCondutor(){
        return condutor;
    }

    public void setCondutor(Condutor condutor){
        this.condutor = condutor;
    }

    public Seguro getSeguro(){
        return seguro;
    }

    public void setSeguro(Seguro seguro){
        this.seguro = seguro;
    }
}