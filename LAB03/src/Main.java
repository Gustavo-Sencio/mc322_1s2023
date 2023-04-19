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

    public static void removerClientePF(Seguradora seg, ClientePF cl_pf){
        boolean verificador = seg.removerCliente(cl_pf.getNome());
        if (verificador){
            System.out.println("O cliente "+cl_pf.getNome()+" foi removido!");
        }else{
            System.out.println("O cliente "+cl_pf.getNome()+" não existe!");
        }
    }

    public static void gerandoSinistro(Seguradora seg, Cliente cliente, Veiculo veiculo){
        boolean verificador = seg.gerarSinistro(cliente, veiculo);

        if (verificador){
            System.out.println("O sinistro foi cadastrado com sucesso!");
        }else{
            System.out.println("O sinistro já existe!");
        }
    }

    public static void menu(Seguradora seg){
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;
        int input;
        int cl;
        List<Cliente> listaClientes;
        List<Sinistro> listaSinistros;
        boolean verificador;
        String str;

        while(loop){
            System.out.println("Selecione alguma das seguinte opcoes:\n"+
            "1 - Listar clientes\n"+
            "2 - Visualizar sinistro\n"+
            "3 - Listar Sinistros\n"+
            "0 - Encerrar menu");

            input = entrada.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Qual tipo de cliente você quer listar?\n" + 
                                       "1 - PF\n2 - PJ");
                    cl = entrada.nextInt();

                    switch (cl) {
                        case 1:
                            listaClientes = seg.listarClientes("PF");
                            System.out.println(listaClientes.toString());
                            break;
                        
                        case 2:
                            listaClientes = seg.listarClientes("PJ");
                            System.out.println(listaClientes.toString());
                            break;
                        
                        default:
                            System.out.println("O valor digitado não está correto.");
                            break;
                    }
                    break;
                
                case 2:
                    System.out.println("Qual é o nome do cliente?");
                    entrada.nextLine();
                    str = entrada.nextLine();
                    verificador = seg.visualizarSinistro(str);
                    if (!verificador){
                        System.out.println("O cliente não possui nenhum sinistro!");
                    }
                    break;

                case 3:
                    listaSinistros = seg.listarSinistros();
                    System.out.println(listaSinistros.toString());
                    break;
                
                case 0:
                    System.out.println("Encerrando o menu.");
                    loop = false;
                    break;

                default:
                    System.out.println("O numero digitado é invalido, por favor escolha uma opcao corretamente");
                    break;
            }
            System.out.println("-------------------------------------");
        }
    } 

    public static void main(String [] args){
        //Cadastrando um cliente PF
        Date dataPF1 = new Date();
        Date data_nascimentoPF1 = new Date();
        List<Veiculo> listaVeiculosPF1 = new ArrayList<Veiculo>();
        ClientePF pf1 = new ClientePF("Rodolfo", "A praia", dataPF1,
                                    "Superior", "Masculino", "Alta", 
                                    listaVeiculosPF1, "039.315.151-41", data_nascimentoPF1);

        //Cadastrando um cliente PF
        Date dataPF2 = new Date();
        Date data_nascimentoPF2 = new Date();
        List<Veiculo> listaVeiculosPF2 = new ArrayList<Veiculo>();
        ClientePF pf2 = new ClientePF("Gustavo", "Campinas", dataPF2,
                                    "Superior", "Masculino", "Baixa", 
                                    listaVeiculosPF2, "002.115.421-90", data_nascimentoPF2);

        //Cadastrando um cliente PJ
        List<Veiculo> listaVeiculosPJ = new ArrayList<Veiculo>();
        Date data_fundacaoPJ = new Date();
        ClientePJ pj = new ClientePJ("Suprema", "Rua otavair", listaVeiculosPJ,
                                    "74.713.561/0001-74", data_fundacaoPJ);

        //Usando os métodos validar
        boolean verificador1 = ClientePF.validarCPF(pf1.getCPF());
        boolean verificador2 = ClientePJ.validarCNPJ(pj.getCNPJ());
        boolean verificador3 = ClientePF.validarCPF(pf2.getCPF());

        //Imprimindo se o CPF e o CNPJ são válidos
        Main.verificarCNPJ(verificador2, pj);
        Main.verificarCPF(verificador1, pf1);
        Main.verificarCPF(verificador3, pf2);

        System.out.println("-------------------------------------");

        //Adicionando um veiculo em cada cliente
        Veiculo v_pf1 = new Veiculo("QYW4R26", "Fiat", "UNO", 2004);
        Veiculo v_pf2 = new Veiculo("ZKA15HP", "Honda", "Civic", 2013);
        Veiculo v_pj = new Veiculo("CXZ4T19", "Nissan", "Kicks", 2007);
        pf1.getListaVeiculos().add(v_pf1);
        pf2.getListaVeiculos().add(v_pf2);
        pj.getListaVeiculos().add(v_pj);

        //Criando uma seguradora
        List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        Seguradora seg = new Seguradora("Direcao responsavel", "(19)98702-2149",    "Direcaoresp@gmail.com", "Jardim Capivari", listaSinistros, listaClientes);

        //Cadastrando os clientes na seguradora
        Main.cadastrarClientePF(seg, pf1);
        Main.cadastrarClientePF(seg, pf2);
        Main.cadastrarClientePJ(seg, pj);

        System.out.println("-------------------------------------");

        //Removendo um cliente
        Main.removerClientePF(seg, pf2);

        System.out.println("-------------------------------------");

        //Gerando um sinistro
        Main.gerandoSinistro(seg, pf1, v_pf1);

        System.out.println("-------------------------------------");

        //chamando o toString
        System.out.println(v_pf1.toString()+"\n");
        boolean v = seg.visualizarSinistro(pf1.getNome());
        System.out.println("\n"+pf1.toString()+"\n");
        System.out.println(pj.toString());

        System.out.println("-------------------------------------");

        //Rodando o menu de uma seguradora
        Main.menu(seg);
    }
}