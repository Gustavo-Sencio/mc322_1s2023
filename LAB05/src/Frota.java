import java.util.*;

public class Frota {
    String code;
    private List<Veiculo> listaVeiculos;
    
    //Construtores
    public Frota(String code){
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

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
    public boolean addVeiculo(Veiculo veiculo){
        boolean out = true;

        for (Veiculo v:getListaVeiculos()){
            if (v.equals(veiculo)){
                out = false;
                break;
            }
        }
        if (out)
            this.listaVeiculos.add(veiculo);
        return out;
    }

    public boolean removerVeiculo(String Placa){
        boolean out = false;

        if (getListaVeiculos().size() > 1){
            for (int i = 0; i < getListaVeiculos().size(); i++){
                if(getListaVeiculos().get(i).getPlaca().equals(Placa)){
                    out = true;
                    this.listaVeiculos.remove(i);
                    break;
                }
            }
        }
        return out;
    }

    @Override
    public String toString() {
        return "Frota [code=" + code + ", listaVeiculos=" + listaVeiculos + "]";
    }
}
