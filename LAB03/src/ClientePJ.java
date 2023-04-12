import java.util.*;

public class ClientePJ extends Cliente{
    private final String CNPJ;
    private Date dataFundacao;

    //Construtores
    public ClientePJ(String CNPJ){
        super();
        this.CNPJ = CNPJ;
    }

    public ClientePJ(String nome, String endereco, Date dataLicenca, 
                        List<Veiculo> listaVeiculos, String CNPJ, Date dataFundacao){
        //Construtor da superclasse
        super(nome, endereco, dataLicenca, listaVeiculos);
        this.CNPJ = CNPJ.replaceAll("[^0-9]+", "");
        this.dataFundacao = dataFundacao;
    }

    //Setters e getters
    public String getCNPJ(){
        return this.CNPJ;
    }

    public Date getDataFundacao(){
        return this.dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao){
        this.dataFundacao = dataFundacao;
    }

    //Outros métodos
    public static boolean validarCNPJ(String CNPJ){
        CNPJ = CNPJ.replaceAll("[^0-9]+", ""); //Tirando os caracteres não numéricos
        if (CNPJ.length() != 14) //Verificando se o CNPJ possui 11 caracteres
            return false;

        //Verificando se todos os caracteres são iguais
        int i;
        char ant = CNPJ.charAt(0);
        boolean verificador = true; //Se o verificador permanecer true apos o for é porque todos os caracteres são iguais

        for (i = 1; i != 14; i++){
            if (ant != CNPJ.charAt(i)){
                verificador = false;
                break;
            }
            ant = CNPJ.charAt(i);
        }

        if (verificador)
            return false;
        
        //Validando os numeros no CNPJ

        char d13, d14;
        int soma, resto, n, peso;

        // Calculo do 1o. Digito Verificador
        soma = 0;
        peso = 2;

        //Coverter os caracteres em int e após fazer o calculo com o peso
        for (i = 11; i>=0; i--){
            n = (int)(CNPJ.charAt(i) - 48);
            soma = soma + (n * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        resto = soma%11;
        if ((resto == 0) || (resto == 1))
            d13 = '0';
        else
            d13 = (char)((11-resto) + 48);
            
        // Calculo do 2o. Digito Verificador
        soma = 0;
        peso = 2;

        for (i = 12; i>=0; i--){
            n = (int)(CNPJ.charAt(i) - 48);
            soma = soma + (n * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        resto = soma%11;
        if ((resto == 0) || (resto == 1))
            d14 = '0';
        else
            d14 = (char)((11-resto) + 48);
            
        //Verificando se os digitos do CPF conferem com os digitos calculados
        if((d13 == CNPJ.charAt(12)) && (d14 == CNPJ.charAt(13)))
            return true;
        else 
            return false;
    }

    @Override
    public String toString(){
        String out = "";
        out += "Nome: "+getNome()+
        "\nEndereco: "+getEndereco()+
        "\nData da licenca: "+getDataLicenca()+
        "\nData fundacao: "+getDataFundacao()+
        "\nCNPJ: "+getCNPJ()+
        "\nVeiculos: "+getListaVeiculos().toString(); //O que está errado?
        return out;
    }
}