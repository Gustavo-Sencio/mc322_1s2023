import java.util.*;

public class Menu {
    public static void principal(Seguradora seg){
        Scanner entrada = new Scanner(System.in);
        boolean loop = true;
        int input;

        while(loop){
            System.out.println("Selecione alguma das seguinte opcoes:\n"+
            "11 - Cadastrar Cliente\n"+
            "12 - Cadastrar Veiculo-PF\n"+
            "13 - Cadastrar Veiculo-Frota"+
            "14 - Cadastrar Frota\n"+
            "15 - Autorizar Condutor\n"+
            "16 - Gerar Seguro\n"+
            "17 - Gerar sinistro\n"+
            "21 - Listar clientes da seguradora\n"+
            "22 - Listar seguros da seguradora\n"+
            "23 - Listar sinistros do cliente\n"+
            "24 - Listar seguros do cliente\n"+
            "25 - Listar veiculos do cliente-PF\n"+
            "26 - Listar frotas do cliente-PJ\n"+
            "31 - Excluir cliente\n"+
            "32 - Excluir seguro\n"+
            "33 - Excluir veiculo da frota\n"+
            "34 - Excluir veiculo clientePF\n"+
            "35 - Desautorizar condutor\n"+
            "4 - Calcular Receita Seguradora\n"+
            "0 - Encerrar menu");
            
            input = entrada.nextInt();
            loop = Menu.processarEntrada(input, seg);
        }
    }

    public static boolean processarEntrada(int input, Seguradora seg){
        Scanner entrada = new Scanner(System.in);
        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        List<Frota> listaFrota = new ArrayList<Frota>();
        int dia, mes, ano;
        Calendar data1 = Calendar.getInstance();
        Calendar data2 = Calendar.getInstance();
        String nome, endereco, telefone, email;
        boolean out = true, existe;
        ClientePF clientePF = new ClientePF();

        switch (input) {
            case 11:
            System.out.println("PF ou PJ?");
            String str = entrada.nextLine();
            
            switch (str) {
                case "PF":
                    System.out.println("Digite o dia, mês e ano de nascimento nesta ordem");
                    dia = entrada.nextInt();
                    mes = entrada.nextInt();
                    ano = entrada.nextInt();
                    data1.set(ano, mes, dia);
                    
                    System.out.println("Digite na seguinte ordem: nome, endereco, telefone, email, educacao, genero, CPF");
                    entrada.nextLine();
                    nome = entrada.nextLine();
                    endereco = entrada.nextLine();
                    telefone = entrada.nextLine();
                    email = entrada.nextLine();
                    String educacao = entrada.nextLine();
                    String genero = entrada.nextLine();
                    String CPF = entrada.nextLine();
                    
                    ClientePF novoPF = new ClientePF(nome, endereco, telefone, email, educacao, genero, CPF, data1, listaVeiculos);
                    AuxiliarMenu.cadastrarClientePF(seg, novoPF);
                    break;
                
                case "PJ":
                    System.out.println("Digite o dia, mês e ano da data de fundacao nesta ordem");
                    dia = entrada.nextInt();
                    mes = entrada.nextInt();
                    ano = entrada.nextInt();
                    data1.set(ano, mes, dia);

                    System.out.println("Digite na seguinte ordem: nome, endereco, telefone, email, CNPJ, qtd de funcionarios");
                    entrada.nextLine();
                    nome = entrada.nextLine();
                    endereco = entrada.nextLine();
                    telefone = entrada.nextLine();
                    email = entrada.nextLine();
                    String CNPJ = entrada.nextLine();
                    int qtd_funcionarios = entrada.nextInt();

                    ClientePJ novoPJ = new ClientePJ(nome, endereco, telefone, email, CNPJ, data1, listaFrota, qtd_funcionarios);
                    AuxiliarMenu.cadastrarClientePJ(seg, novoPJ);
                    break;

                default:
                    System.out.println("O valor digitado não corresponde com as opcoes");
                    break;
            }
                break;

            case 12:
                existe = false;
                System.out.println("Qual cliente que o veiculo será adicionado?");
                String cl = entrada.nextLine();

                for (Cliente c:seg.getListaClientes()){
                    if(c.getNome().equals(cl)){
                        clientePF = (ClientePF)c;
                        existe = true;
                        break;
                    }
                }             
                if (existe){
                    System.out.println("Digite na seguinte ordem: Ano de fabricacao, placa, marca, modelo");
                    int anoFabricacao = entrada.nextInt();
                    entrada.nextLine();
                    String placa = entrada.nextLine();
                    String marca = entrada.nextLine();
                    String modelo = entrada.nextLine();
                    Veiculo n_veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                    clientePF.getListaVeiculos().add(n_veiculo);
                    System.out.println("Veiculo cadastrado com sucesso");
                } else {
                    System.out.println("O cliente não existe");
                }
                break;
        
            case 13:
                
                
                break;

            case 14:
                
                break;

            case 15:
                
                break;

            case 16:
                
                break;

            case 17:
                
                break;
            
            case 21:
                
                break;

            case 22:
                
                break;                

            case 23:
                
                break;
            
            case 24:
                
                break;

            case 25:
                
                break;

            case 26:
                
                break;

            case 31:
                
                break;

            case 32:
                
                break;

            case 33:
                
                break;

            case 34:
                
                break;

            case 35:
                
                break;

            case 4:
                
                break;
            
            case 0:
                
                break;

            default:
                System.out.println("O valor digitado não corresponde com as opcoes");
                break;
        }

        return out;
    }
}

