import java.util.*;

public class Cliente{
    protected String nome;
    protected String endereco;
    protected Date dataLicenca;
    protected List<Veiculo> listaVeiculos;

    //Construtores
    public Cliente(){
        this.dataLicenca = new Date();
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    public Cliente(String nome, String endereco, Date dataLicenca, List<Veiculo> listaVeiculos){
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.listaVeiculos = listaVeiculos;
    }

    //Setters e getters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }


    public Date getDataLicenca(){
        return this.dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca){
        this.dataLicenca = dataLicenca;
    }


    public List<Veiculo> getListaVeiculos(){
        return this.listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos){
        this.listaVeiculos = listaVeiculos;
    }

    //Outros métodos
    public String toString(){
        String out = "";
        out += "NOME: "+getNome()+
        "\nENDERECO: "+getEndereco()+
        "\nData da licenca: "+getDataLicenca()+
        "\nVeiculos: "+getListaVeiculos().toString(); //O que está errado?
        return out;
    }
}