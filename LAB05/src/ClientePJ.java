import java.util.*;

public class ClientePJ extends Cliente{
    private final String CNPJ;
    private Calendar dataFundacao;
    private List<Frota> listaFrota;

    //Construtor
    public ClientePJ(String nome, String endereco, String telefone, String email, String CNPJ, Calendar dataFundacao,
            List<Frota> listaFrota) {
        super(nome, endereco, telefone, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrota = listaFrota;
    }

    //Getters e Setters
    public String getCNPJ() {
        return CNPJ;
    }

    public Calendar getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Calendar dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public List<Frota> getListaFrota() {
        return listaFrota;
    }

    public void setListaFrota(List<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    //Outros métodos
    @Override
    public String toString() {
        return "ClientePJ [CNPJ=" + CNPJ + ", dataFundacao=" + dataFundacao + ", listaFrota=" + listaFrota + "]";
    } 
}
