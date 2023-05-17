import java.util.*;

public class Frota {
    String code;
    private List<Veiculo> listaVeiculos;
    
    //Construtor
    public Frota(String code, List<Veiculo> listaVeiculos) {
        this.code = code;
        this.listaVeiculos = listaVeiculos;
    }

    //Setters e Getters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return "Frota [code=" + code + ", listaVeiculos=" + listaVeiculos + "]";
    }
}
