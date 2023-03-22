//import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        //Testando a classe cliente
        Cliente cl = new Cliente("Gustavo", "039.315.151-41", "27/09/2002", 20, "Dic III"); //Cpf do Luan Santana
        System.out.println("O nome do cliente é: " + cl.getNome());
        cl.setNome("Yasmin");
        System.out.println("O nome do cliente alterado é: " + cl.getNome());
        System.out.println("O CPF é: " + cl.validarCPF());
        
        //Testando seguradora
        Seguradora sg = new Seguradora("SLA", "(11) 4002-8922", "SLA.seguradoranaosegura@seguro.com", "Jardim petropolis"); //Telefone do bom dia e compania
        System.out.println("O telefone da seguradora é: " + sg.getTelefone());
        sg.setTelefone("(19) 982057458");
        System.out.println("O novo telefone da seguradora é: " + sg.getTelefone());

        //Testando sinistro
        Sinistro si = new Sinistro("28/10/2018", "Jardim petropolis");
        System.out.println("A data do sinistro é:" + si.getData());
        si.setData("11/11/2011");
        System.out.println("A nova data do sinistro é:" + si.getData());
        System.out.println("O id é:" + si.getId());

        //Testando veiculo
        Veiculo vc = new Veiculo("GGX-4850", "Citroen", "C3");
        System.out.println("A placa do veículo é:" + vc.getPlaca());
        vc.setPlaca("GAH-2011");
        System.out.println("A nova placa do veículo é:" + vc.getPlaca());
    }
}