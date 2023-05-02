import java.util.*;

public class ClientePF extends Cliente{
    private final String CPF;
    private Calendar dataNascimento;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private Calendar dataLicenca;

    //Construtores
    public ClientePF(String CPF){
        super();
        this.CPF = CPF.replaceAll("[^0-9]+", "");
    }

    public ClientePF(String nome, String endereco, Calendar dataLicenca,
                        String educacao, String genero, String classeEconomica,
                        List<Veiculo> listaVeiculos, String cpf, Calendar dataNascimento){
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

    public Calendar getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public Calendar getDataLicenca(){
        return this.dataLicenca;
    }

    public void setDataLicenca(Calendar dataLicenca){
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
        int ano_nascimento = this.dataNascimento.get(Calendar.YEAR);
        int idade = 2023 - ano_nascimento;
        double fator_idade;

        if ((idade >= 18) && (idade <= 30))
            fator_idade = calcSeguro.FATOR_18_30.valor();
        else if ((idade > 30) && (idade <= 60))
            fator_idade = calcSeguro.FATOR_30_60.valor();
        else if ((idade > 60) && (idade <= 90))
            fator_idade = calcSeguro.FATOR_60_90.valor();
        else //Caso o cliente não esteja nas faixas etarias destacadas
            fator_idade = 1.0; //o fator_idade nao deve alterar a conta
        
        double out = calcSeguro.VALOR_BASE.valor() * fator_idade * this.listaVeiculos.size();
        return out;
    }
}


