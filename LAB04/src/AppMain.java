import java.util.*;
import menus.*;

public class AppMain{
    public static void main(String [] args){
        //Cadastrando um cliente PF
        Calendar data_nascimento = Calendar.getInstance();
        data_nascimento.set(1980, 2, 24);
        Calendar data_licensa = Calendar.getInstance();
        data_licensa.set(2015, 1, 23);
        List<Veiculo> listaVeiculosPF = new ArrayList<Veiculo>();
        ClientePF Rodolfo = new ClientePF("Rodolfo", "Regiao urbana de SP", 
                                         data_licensa, "Superior", "Masculino",
                                        "Alta", listaVeiculosPF, "039.315.151-41", 
                                        data_nascimento);
        
        //Cadastrando um cliente PJ
        Calendar data_fundacao = Calendar.getInstance();
        data_fundacao.set(1990, 10, 2);
        List<Veiculo> listaVeiculosPJ = new ArrayList<Veiculo>();
        ClientePJ Suprema = new ClientePJ("Suprema", "Rua nao sei oq", listaVeiculosPJ,
                                        "74.713.561/0001-74", data_fundacao, 30);
        
        //Adicionando um veiculo em cada cliente
        Veiculo v_pf = new Veiculo("QYW4R26", "Fiat", "Uno", 2002);
        Veiculo v_pj = new Veiculo("ZKA15HP", "Honda", "Civic", 2014);
        Rodolfo.getListaVeiculos().add(v_pf);
        Suprema.getListaVeiculos().add(v_pj);

        //Criando uma seguradora
        List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        Seguradora seg = new Seguradora("Direcao responsavel", "(19)98702-2149",
        "Direcaoresp@gmail.com", "Jardim Capivari", listaSinistros, listaClientes);

        //Cadastrando os clientes na seguradora
        AppMain.cadastrarClientePF(seg, Rodolfo);
        AppMain.cadastrarClientePJ(seg, Suprema);

        System.out.println("-------------------------------------");

        //Gerando um sinistro em cada cliente
        AppMain.gerandoSinistro(seg, Rodolfo, v_pf);
        AppMain.gerandoSinistro(seg, Suprema, v_pj);

        System.out.println("-------------------------------------");
        
        Listar list;
    }

    public static void gerandoSinistro(Seguradora seg, Cliente cliente, Veiculo veiculo){
        boolean verificador = seg.gerarSinistro(cliente, veiculo);

        if (verificador){
            System.out.println("O sinistro foi cadastrado com sucesso!");
        }else{
            System.out.println("O sinistro já existe!");
        }
    }

    public static void cadastrarClientePF(Seguradora seg, ClientePF cl_pf){
        boolean verificador = seg.cadastrarCliente(cl_pf);
        if (verificador){
            System.out.println("O cliente "+cl_pf.getNome()+" foi cadastrado!");
        }else{
            System.out.println("O cliente "+cl_pf.getNome()+" já está cadastrado!");
        }
    }

    public static void cadastrarClientePJ(Seguradora seg, ClientePJ cl_pj){
        boolean verificador = seg.cadastrarCliente(cl_pj);
        if (verificador){
            System.out.println("O cliente "+cl_pj.getNome()+" foi cadastrado!");
        }else{
            System.out.println("O cliente "+cl_pj.getNome()+" já está cadastrado!");
        }
    }

    public static void menu(Seguradora seg){
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;
        int input;

        while(loop){
            System.out.println("Selecione alguma das seguinte opcoes:\n"+
            "1 - Cadastros\n"+
            "2 - Listar\n"+
            "3 - Excluir\n"+
            "4 - Gerar Sinistro\n"+
            "5 - Transferir Seguro\n"+
            "6 - Calcular Receita Seguradora\n"+
            "0 - Encerrar menu");
            
            input = entrada.nextInt();
        }
    }
}