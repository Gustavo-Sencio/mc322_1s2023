import java.util.*;

public class ClientePJ extends Cliente{
    private final String CNPJ;
    private Calendar dataFundacao;
    private List<Frota> listaFrota;
    private int qtdFuncionarios;

    //Construtor
    public ClientePJ(String nome, String endereco, String telefone, String email, String CNPJ, Calendar dataFundacao,
            List<Frota> listaFrota, int qtdFuncionarios) {
        super(nome, endereco, telefone, email);
        this.CNPJ = CNPJ;
        this.dataFundacao = dataFundacao;
        this.listaFrota = listaFrota;
        this.qtdFuncionarios = qtdFuncionarios;
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

    public boolean atualizarFrota(char option, Veiculo veiculo, String code){
        boolean out = false;

        if ((option == 'A') || (option == 'a')){
            for (int i = 0; i < getListaFrota().size(); i++){
                if (getListaFrota().get(i).getCode().equals(code)){
                    out = getListaFrota().get(i).addVeiculo(veiculo);
                }
            }
        }

        if ((option == 'R') || (option == 'r')){
            for (int i = 0; i < getListaFrota().size(); i++){
                if (getListaFrota().get(i).getCode().equals(code)){
                    for (Veiculo v:getListaFrota().get(i).getListaVeiculos()){
                        if (v.equals(veiculo)){
                            out = getListaFrota().get(i).removerVeiculo(veiculo.getPlaca());
                        }
                    }
                }
            }
        }
        
        return out;
    }

    public boolean atualizarFrota(String code){
        boolean out = false;

        for (int i = 0; i < getListaFrota().size(); i++){
            if (getListaFrota().get(i).getCode().equals(code)){
                out = true;
                this.listaFrota.remove(i);
            }
        }

        return out;
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
        return out;
    }

    @Override
    public String toString() {
        return "ClientePJ [CNPJ=" + CNPJ + ", listaFrota=" + listaFrota + "]";
    } 
}
