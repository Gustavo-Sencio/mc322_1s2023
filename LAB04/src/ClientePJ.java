import java.util.*;

public class ClientePJ extends Cliente{
    private final String CNPJ;
    private Calendar dataFundacao;
    private int qtdFuncionarios;

    //Construtores
    public ClientePJ(String CNPJ){
        super();
        this.CNPJ = CNPJ;
    }

    public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, 
                    String CNPJ, Calendar dataFundacao, int qtdFuncionarios){
        //Construtor da superclasse
        super(nome, endereco, listaVeiculos);
        this.CNPJ = CNPJ.replaceAll("[^0-9]+", "");
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
    }

    //Setters e getters
    public String getCNPJ(){
        return this.CNPJ;
    }

    public Calendar getDataFundacao(){
        return this.dataFundacao;
    }

    public void setDataFundacao(Calendar dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    public int getQtdFuncionarios(){
        return this.qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios){
        this.qtdFuncionarios = qtdFuncionarios;
    }

    //Outros métodos

    @Override
    public String toString(){
        String out = "";
        out += "Nome: "+getNome()+
        "\nEndereco: "+getEndereco()+
        "\nData fundacao: "+getDataFundacao()+
        "\nCNPJ: "+getCNPJ()+
        "\nVeiculos: "+getListaVeiculos().toString(); //O que está errado?
        return out;
    }

    @Override
    public double calculaScore(){
        double out = calcSeguro.VALOR_BASE.valor() * (1 + ((this.qtdFuncionarios/100) * this.listaVeiculos.size()));
        return out;
    }
}