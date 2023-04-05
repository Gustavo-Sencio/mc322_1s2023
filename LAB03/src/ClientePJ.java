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

    }

    @Override
    public String toString(){
        
    }
}