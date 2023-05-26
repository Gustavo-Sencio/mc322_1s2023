import java.util.*;

public class SeguroPJ extends Seguro{
    Frota frota;
    ClientePJ cliente;

    public SeguroPJ(Calendar dataInicio, Calendar dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;

        this.valorMensal = calcularValor();
    }

    //Getters e Setters
    public Frota getFrota() {
        return frota;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }
    public ClientePJ getCliente() {
        return cliente;
    }
    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    //Outros métodos
    public boolean autorizarCondutor(Condutor condutor){
        boolean out = true;

        for (Condutor c:getListaCondutores()){
            if(c.equals(condutor)){
                out = false;
                break;
            }
        }

        if (out)
            listaCondutores.add(condutor);
        
        setValorMensal(calcularValor());
        return out;
    }

    public boolean desautorizarCondutor(String condutor){
        boolean out = false;
        Condutor cond;

        for (int i = 0; i<getListaCondutores().size(); i++){
            if(getListaCondutores().get(i).getNome().equals(condutor)){ //Se o condutor está na lista
                out = true;
                cond = getListaCondutores().get(i);
                this.listaCondutores.remove(i); //Remova ele
                break;
            }
        }

        //agora devo remover os sinistros do condutor
        for (int i = getListaSinistros().size() - 1; i >= 0; i--){
            if (getListaSinistros().get(i).getCondutor().equals(cond))
                this.listandoSinistros().remove(i);
        }

        setValorMensal(calcularValor());
        return out;
    }

    public boolean gerarSinistro(Calendar data, String endereco, Condutor condutor){
        boolean out = false;
        int indice = 0;

        for (int i = 0; i<getListaCondutores().size(); i++){ //Se o condutor estiver autorizado o sinistro é adicionado
            if(getListaCondutores().get(i).equals(condutor)){
                indice = i;
                out = true;
                break;
            }
        }

        if (out){
            Sinistro novo_sinistro = new Sinistro(data, endereco, condutor, this);
            this.listaSinistros.add(novo_sinistro);
            this.listaCondutores.get(indice).adicionarSinistro(novo_sinistro);
        }
        setValorMensal(calcularValor());

        return out;
    }

    public double calcularValor(){
        int anoFundacao = getCliente().getDataFundacao().get(Calendar.YEAR);
        int AnosPosfundacao = 2023 - anoFundacao;
        int qtdSinistrosCondutor = 0;

        for (Condutor c:getListaCondutores())
            qtdSinistrosCondutor += c.getListaSinistros().size();
        
        double valor = calcSeguro.VALOR_BASE.valor() * (10 + ((double)getCliente().getQtdFuncionarios()/10)) * 
        (1 + 1/(getFrota().getListaVeiculos().size() + 2)) * (1 + 1/(AnosPosfundacao + 2)) * 
        (2 + ((double)getListaSinistros().size()/10)) * (5 + ((double)qtdSinistrosCondutor/10));
        
        return valor;
    }

    @Override
    public String toString() {
        return "SeguroPJ [frota=" + frota + ", cliente=" + cliente + "]";
    }
}
