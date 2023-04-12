import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        //Cadastrando um cliente PF
        Date dataPF = new Date();
        Date data_nascimentoPF = new Date();
        List<Veiculo> listaVeiculosPF = new ArrayList<Veiculo>();
        ClientePF pf = new ClientePF("Rodolfo", "A praia", dataPF, "Superior", "Masculino", "Alta", listaVeiculosPF, "039.315.151-41", data_nascimentoPF);

        //Cadastrando um cliente PJ
        Date dataPJ = new Date();
        List<Veiculo> listaVeiculosPJ = new ArrayList<Veiculo>();
        Date data_fundacaoPJ = new Date();
        ClientePJ pj = new ClientePJ("Suprema", "Rua otavair", dataPJ, listaVeiculosPJ, "74.713.561/0001-74", data_fundacaoPJ);

        //Usando os métodos validar
    }

    public void lerClientePF(){

    }

}