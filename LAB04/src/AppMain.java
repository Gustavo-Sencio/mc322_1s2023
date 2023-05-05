import java.util.*;

public class AppMain{
    public static void main(String [] args){
        double x = calcSeguro.VALOR_BASE.valor();
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
        
        //Chamando alguns métodos da seguradora
        AppMain.listandoClientes(seg, "PF");
        AppMain.listandoClientes(seg, "PJ");
        boolean lixo = seg.visualizarSinistro("Rodolfo");
        AppMain.listandoSinistros(seg, Rodolfo);
        AppMain.atualizar_valores(seg);
        seg.calcularReceita();

        //Chamando o menu
        AppMain.menu(seg);
    }

    public static void atualizar_valores(Seguradora seg){
        for (int i = 0; i < seg.getListaClientes().size(); i++){
            seg.getListaClientes().get(i).setValorSeguro(seg.calcularPrecoSeguroCliente(seg.getListaClientes().get(i)));
        }
    }

    public static void listandoSinistros(Seguradora seg, Cliente cliente){
        List<Sinistro> lista = seg.listarSinistros(cliente);

        for (Sinistro s:lista){
            s.toString();
            System.out.println("******************************");
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

    public static void listandoClientes(Seguradora seg, String tipo_cliente){
        List<Cliente> lista = seg.listarClientes(tipo_cliente);
        for(Cliente c:lista){
            System.out.println(" - " + c.getNome());
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
        MenuOperacoes menu;

        while(loop){
            System.out.println("Selecione alguma das seguinte opcoes:\n"+
            "11 - Cadastrar cliente\n"+
            "12 - Cadastrar Veiculo\n"+
            "13 - Cadastrar Seguradora\n"+
            "21 - Listar clientes da seguradora\n"+
            "22 - Listar sinistros da seguradora\n"+
            "23 - Listar sinistros do cliente\n"+
            "24 - Listar veiculos do cliente\n"+
            "25 - listar veiculos da seguradora\n"+
            "31 - Excluir cliente\n"+
            "32 - Excluir veiculo\n"+
            "33 - Excluir sinistro\n"+
            "4 - Gerar Sinistro\n"+
            "5 - Transferir Seguro\n"+
            "6 - Calcular Receita Seguradora\n"+
            "0 - Encerrar menu");
            
            input = entrada.nextInt();
            
            switch (input) {
                case 11:
                    menu = MenuOperacoes.CADASTRAR_CLIENTE;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;
                
                case 12:
                    menu = MenuOperacoes.CADASTRAR_VEICULO;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 13:
                    menu = MenuOperacoes.CADASTRAR_SEGURADORA;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 21:
                    menu = MenuOperacoes.LISTAR_CLIENTE_SEG;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 22:
                    menu = MenuOperacoes.LISTAR_SINISTROS_SEG;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 23:
                    menu = MenuOperacoes.LISTAR_SINISTROS_CLIENTE;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 24:
                    menu = MenuOperacoes.LISTAR_VEICULOS_CLIENTE;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 25:
                    menu = MenuOperacoes.LISTAR_VEICULOS_SEGURADORA;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 31:
                    menu = MenuOperacoes.EXCLUIR_CLIENTE;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 32:
                    menu = MenuOperacoes.EXCLUIR_VEICULO;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 33:
                    menu = MenuOperacoes.EXCLUIR_SINISTRO;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;
                
                case 4:
                    menu = MenuOperacoes.GERAR_SINISTRO;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 5:
                    menu = MenuOperacoes.TRANSFERIR_SEGURO;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 6:
                    menu = MenuOperacoes.CALCULAR_RECEITA_SEGURADORA;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;

                case 0:
                    menu = MenuOperacoes.SAIR;
                    loop = MenuOperacoes.processarEntrada(menu, seg);
                    break;
                
                default:
                    System.out.println("O valor digitado não corresponde com as opcoes");
                    break;
            }
            System.out.println("-------------------------------------");
        }
    }
}