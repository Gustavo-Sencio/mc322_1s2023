public abstract class Seguro {
    protected final int id;
    protected static int id_atual = 0;
    protected Calendar dataInicio;
    protected Calendar dataFim;
    protected Seguradora seguradora;
    protected int valorMensal;
    protected List<Sinistro> listaSinistros;
    protected List<Condutor> listaCondutores;

    public Seguro(Calendar dataInicio, Calendar dataFim, Seguradora seguradora, int valorMensal){
        this.id = id_atual;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.valorMensal = valorMensal;
        this.listaSeguros = new ArrayList<Sinistro>();
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

    public int getValorMensal(){
        return valorMensal;
    }

    public void setValorMensal(int valorMensal){
        this.valorMensal = valorMensal;
    }

    public List<Sinistro> getListaSinistros(){
        return this.listaSinistros;
    }

    public List<Condutor> getListaCondutores(){
        return this.listaCondutores;
    }

    public void setListaCondutores(List<Condutor>){
        this.listaCondutores = listaCondutores;
    }

    //outros métodos
    public abstract void desautorizarCondutor(Condutor condutor){

    }

    public abstract void autorizarCondutor(Condutor condutor){

    }

    public abstract void gerarSinistro(){

    }

    public abstract double calcularValor(){
        
    }
}
