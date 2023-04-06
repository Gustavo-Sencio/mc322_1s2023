import java.util.*;

public class ClientePF extends Cliente{
    private final String CPF;
    private Date dataNascimento;
    private String educacao;
    private String genero;
    private String classeEconomica;

    //Construtores
    public ClientePF(String CPF){
        super();
        this.CPF = CPF.replaceAll("[^0-9]+", "");
    }

    public ClientePF(String nome, String endereco, Date dataLicenca,
                        String educacao, String genero, String classeEconomica,
                        List<Veiculo> listaVeiculos, String cpf, Date dataNascimento){
        //Construtor da superclasse
        super(nome, endereco, dataLicenca, listaVeiculos);
        this.CPF = cpf.replaceAll("[^0-9]+", "");
        this.dataNascimento = dataNascimento;
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
    public static boolean validarCPF(String CPF){
        CPF = CPF.replaceAll("[^0-9]+", ""); //Tirando os caracteres não numéricos
        if (CPF.length() != 11) //Verificando se o CPF possui 11 caracteres
            return false;

        //Verificando se todos os caracteres são iguais
        int i;
        char ant = CPF.charAt(0);;
        boolean verificador = true; //Se o verificador permanecer true apos o for é porque todos os caracteres são iguais

        for (i = 1; i != 11; i++){
            if (ant != CPF.charAt(i)){
                verificador = false;
                break;
            }
            ant = CPF.charAt(i);
        }

        if (verificador)
            return false;

        //Validando os numeros no cpf

        //Calculo do 1º digito verificador
        char d10, d11;
        int soma = 0, resto, n, peso = 10;

        //Primeiro eu vou converter os caracteres do cpf em int e após fazer o calculo com o peso correspondente
        for(i = 0; i<9; i++){
            n = (CPF.charAt(i)) - 48;
            soma = soma + (n * peso);
            peso--;
        }

        resto = 11 - (soma%11);
        if((resto == 11) || (resto == 10))
            d10 = '0';
        else d10 = (char)(resto + 48);

        //Calculo do 2º digito verificador
        soma = 0;
        peso = 11;
        for (i = 0; i<10; i++){
            n = (CPF.charAt(i)) - 48;
            soma = soma + (n * peso);
            peso--;
        }

        resto = 11 - (soma%11);
        if ((resto == 11) || (resto == 10))
            d11 = '0';
        else d11 = (char)(resto + 48);

        //Verificando se os digitos do CPF conferem com os digitos calculados
        if((d10 == CPF.charAt(9)) && (d11 == CPF.charAt(10)))
            return true;
        else return false;
    }

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
        "\nVeiculos: "+Arrays.toString(getListaVeiculos()); //O que está errado?
        return out;
    }
}


