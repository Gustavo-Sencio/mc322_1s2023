import java.util.*;

public abstract class Seguro {
    protected final int id;
    protected static int id_atual = 0;
    protected Calendar dataInicio;
    protected Calendar dataFim;
    protected Seguradora seguradora;
    protected double valorMensal;
    protected List<Sinistro> listaSinistros;
    protected List<Condutor> listaCondutores;

    public Seguro(Calendar dataInicio, Calendar dataFim, Seguradora seguradora){
        this.id = id_atual;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();

        //Somando o id para nunca existirem dois id's iguais
        id_atual++;
    }

    //Setters e getters
    public int getId(){
        return id;
    }

    public Calendar getDataInicio(){
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio){
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim(){
        return dataFim;
    }

    public void setDataFim(Calendar dataFim){
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora(){
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public double getValorMensal(){
        return valorMensal;
    }

    public void setValorMensal(double valorMensal){
        this.valorMensal = valorMensal;
    }

    public List<Sinistro> getListaSinistros(){
        return this.listaSinistros;
    }

    public List<Condutor> getListaCondutores(){
        return this.listaCondutores;
    }

    public void setListaCondutores(List<Condutor> listaCondutores){
        this.listaCondutores = listaCondutores;
    }

    //outros métodos
    public abstract boolean desautorizarCondutor(String condutor);

    public abstract boolean autorizarCondutor(Condutor condutor);

    public abstract boolean gerarSinistro(Calendar data, String endereco, Condutor condutor);

    public abstract double calcularValor();
}
