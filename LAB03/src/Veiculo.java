public class Veiculo{
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    // Construtor

    public Veiculo(String placa, String marca, String modelo, int anoFabricacao){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    // Getters e setters
    public String getPlaca(){
        return this.placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public int getAnoFabricacao(){
        return this.anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }

    //outros métodos
    public String toString(){
        String out = "";
        out += "Placa: "+getPlaca()+
        "\nMarca: "+getMarca()+
        "\nModelo: "+getModelo()+
        "\nAno de fabricacão: "+getAnoFabricacao();
        return out;
    }
}