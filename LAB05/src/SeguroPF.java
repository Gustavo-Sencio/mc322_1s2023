import java.util.*;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;
    

    //Construtores
    public SeguroPF(){
        super();
    }

    public SeguroPF(Calendar dataInicio, Calendar dataFim, Seguradora seguradora, Veiculo veiculo,
            ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;

        this.valorMensal = calcularValor();
    }

    //Getters e Setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = (ClientePF)cliente;
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
        Condutor cond = getListaCondutores().get(0);

        for (int i = 0; i<getListaCondutores().size(); i++){
            if(getListaCondutores().get(i).getNome().equals(condutor)){ //Se o condutor está na lista
                out = true;
                cond = getListaCondutores().get(i);
                this.listaCondutores.remove(i); //Remova ele
                break;
            }
        }

        //agora devo remover os sinistros do condutor
        if (out){
            for (int i = getListaSinistros().size() - 1; i >= 0; i--){
                if (getListaSinistros().get(i).getCondutor().equals(cond))
                    this.listaSinistros.remove(i);
            }
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
        int ano_nascimento = getCliente().getDataNascimento().get(Calendar.YEAR);
        int idade = 2023 - ano_nascimento;
        double fator_idade;
        int qtdSinistrosCondutor = 0;

        if (idade <= 30)
            fator_idade = calcSeguro.FATOR_0_30.valor();
        else if ((idade > 30) && (idade <= 60))
            fator_idade = calcSeguro.FATOR_30_60.valor();
        else if (idade > 60)
            fator_idade = calcSeguro.FATOR_60_150.valor();
        else //Caso o cliente não esteja nas faixas etarias destacadas
            fator_idade = 1.0; //o fator_idade nao deve alterar a conta
        
        for (Condutor c:getListaCondutores())
            qtdSinistrosCondutor += c.getListaSinistros().size();
        
        double valor = calcSeguro.VALOR_BASE.valor() * fator_idade * (1 + 1/(getCliente().getListaVeiculos().size() + 2)) * 
        (2 + ((double)getListaSinistros().size()/10)) * (5 + ((double)qtdSinistrosCondutor/10));
        
        return valor;
    }

    @Override
    public String toString() {
        return "SeguroPF [ID=" +id+ "veiculo=" + veiculo + ", cliente=" + cliente + ", listaSinistros=" +listaSinistros+ ", listaCondutores=" +listaCondutores+"]";
    }
}
