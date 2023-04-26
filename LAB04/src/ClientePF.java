import java.util.*;

public class ClientePF extends Cliente{
    private final String CPF;
    private Date dataNascimento;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private Date dataLicenca;

    //Construtores
    public ClientePF(String CPF){
        super();
        this.CPF = CPF.replaceAll("[^0-9]+", "");
    }

    public ClientePF(String nome, String endereco, Date dataLicenca,
                        String educacao, String genero, String classeEconomica,
                        List<Veiculo> listaVeiculos, String cpf, Date dataNascimento){
        //Construtor da superclasse
        super(nome, endereco, listaVeiculos);
        this.CPF = cpf.replaceAll("[^0-9]+", "");
        this.dataNascimento = dataNascimento;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
    }

    //Setters e getters
    public String getCPF(){
        return this.CPF;
    }

    public Date getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public Date getDataLicenca(){
        return this.dataLicenca;
    }

    public void setDataLicenca(Date dataLicenca){
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao(){
        return this.educacao;
    }

    public void setEducacao(String educacao){
        this.educacao = educacao;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getClasseEconomica(){
        return this.classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica){
        this.classeEconomica = classeEconomica;
    }

    //Outros métodos

    @Override
    public String toString(){
        String out = "";
        out += "Nome: "+getNome()+
        "\nEndereco: "+getEndereco()+
        "\nData da licenca: "+getDataLicenca()+
        "\nCPF: "+getCPF()+
        "\nData Nascimento: "+getDataNascimento()+
        "\nEducacao: "+getEducacao()+
        "\nGenero: "+getGenero()+
        "\nClasse Economica: "+getClasseEconomica()+
        "\nVeiculos: "+getListaVeiculos().toString();
        return out;
    }
    
    @Override
    public double calculaScore(){
        double out = calcSeguro.VALOR_BASE.valor();
        
        return 0.0;
    }
}


