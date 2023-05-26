import java.util.*;

public class ClientePJ extends Cliente{
    private final String CNPJ;
    private Calendar dataFundacao;
    private List<Frota> listaFrota;
    private int qtdFuncionarios;

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

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public List<Frota> getListaFrota() {
        return listaFrota;
    }

    public void setListaFrota(List<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    //Outros métodos
    public boolean cadastrarFrota(Frota frota){
        boolean out = true;

        for (Frota f:getListaFrota()){
            if (f.equals(frota)){
                out = false;
                break;
            }
        }

        if (frota.getListaVeiculos().size() == 0) //se a frota não tem veiculos ela não pode existir
            out = false;

        if (out)
            this.listaFrota.add(frota);
        return out;
    }

    public boolean atualizarFrota(???){
        
    }

    public boolean getVeiculosPorFrota(String code){
        boolean out = false;
        
        for (Frota c : getListaFrota()){
            if (c.getCode().equals(code)){
                out = true;
                System.out.println(c.getListaVeiculos());
                break;
            }
        }
        if(!out){
            System.out.println("O codigo não existe!");
        }
    }

    @Override
    public String toString() {
        return "ClientePJ [CNPJ=" + CNPJ + ", dataFundacao=" + dataFundacao + ", listaFrota=" + listaFrota + "]";
    } 
}
