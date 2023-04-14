import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void verificarCPF(boolean v, ClientePF cliente){
        if (v){
            System.out.println("O CPF: "+cliente.getCPF()+" é valido!");
        }else{
            System.out.println("O CPF: "+cliente.getCPF()+" é invalido!");
        }
    }

    public static void verificarCNPJ(boolean v, ClientePJ cliente){
        if (v){
            System.out.println("O CNPJ: "+cliente.getCNPJ()+" é valido!");
        }else{
            System.out.println("O CNPJ: "+cliente.getCNPJ()+" é invalido!");
        }
    }

    public static void main(String [] args){
        //Cadastrando um cliente PF
        Date dataPF = new Date();
        Date data_nascimentoPF = new Date();
        List<Veiculo> listaVeiculosPF = new ArrayList<Veiculo>();
        ClientePF pf = new ClientePF("Rodolfo", "A praia", dataPF,
                                    "Superior", "Masculino", "Alta", 
                                    listaVeiculosPF, "039.315.151-41", data_nascimentoPF);

        //Cadastrando um cliente PJ
        List<Veiculo> listaVeiculosPJ = new ArrayList<Veiculo>();
        Date data_fundacaoPJ = new Date();
        ClientePJ pj = new ClientePJ("Suprema", "Rua otavair", listaVeiculosPJ,
                                    "74.713.561/0001-74", data_fundacaoPJ);

        //Usando os métodos validar
        boolean verificador = ClientePF.validarCPF(pf.getCPF());
        boolean verificador2 = ClientePJ.validarCNPJ(pj.getCNPJ());

        //Imprimindo se o CPF e o CNPJ são válidos
        Main.verificarCNPJ(verificador2, pj);
        Main.verificarCPF(verificador, pf);
    }
}