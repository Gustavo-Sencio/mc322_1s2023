import java.util.*;

public class ClientePF extends Cliente{
    private String educacao;
    private String genero;
    private final String CPF;
    private Calendar dataNascimento;
    private List<Veiculo> listaVeiculos;

    //Construtor
    public ClientePF(String nome, String endereco, String telefone, String email, String educacao, String genero,
            String CPF, Calendar dataNascimento, List<Veiculo> listaVeiculos) {
        super(nome, endereco, telefone, email);
        this.educacao = educacao;
        this.genero = genero;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.listaVeiculos = listaVeiculos;
    }

    //Getters e Setters
    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCPF() {
        return CPF;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    //Outros métodos
    @Override
    public String toString() {
        return "ClientePF [educacao=" + educacao + ", genero=" + genero + ", CPF=" + CPF + ", dataNascimento="
                + dataNascimento + ", listaVeiculos=" + listaVeiculos + "]";
    }
    
}
