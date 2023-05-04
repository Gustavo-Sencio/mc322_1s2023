import java.util.*;

public enum MenuOperacoes{
    CADASTRAR_CLIENTE(11),
    CADASTRAR_VEICULO(12),
    CADASTRAR_SEGURADORA(13),
    LISTAR_CLIENTE_SEG(21),
    LISTAR_SINISTROS_SEG(22),
    LISTAR_SINISTROS_CLIENTE(23),
    LISTAR_VEICULOS_CLIENTE(24),
    LISTAR_VEICULOS_SEGURADORA(25),
    EXCLUIR_CLIENTE(31),
    EXCLUIR_VEICULO(32),
    EXCLUIR_SINISTRO(33),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALCULAR_RECEITA_SEGURADORA(6),
    SAIR(0);

    private final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int Operacao(){
        return this.operacao;
    }

    public static boolean processarEntrada(MenuOperacoes menu, Seguradora seg){
        Scanner entrada = new Scanner(System.in);
        boolean out = true;
        int dia, mes, ano;
        String nome, endereco;
        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        boolean existe;
        Cliente cliente = new Cliente();

        switch (menu) {
            case CADASTRAR_CLIENTE:
            entrada.nextLine();
            System.out.println("PF ou PJ?");
            String str = entrada.nextLine();
            
            switch (str) {
                case "PF":
                    System.out.println("Digite o dia, mês e ano de nascimento nesta ordem");
                    dia = entrada.nextInt();
                    mes = entrada.nextInt();
                    ano = entrada.nextInt();
                    Calendar data_nascimento = Calendar.getInstance();
                    data_nascimento.set(ano, mes, dia);
        
                    System.out.println("Digite o dia, mês e ano da licensa nesta ordem");
                    dia = entrada.nextInt();
                    mes = entrada.nextInt();
                    ano = entrada.nextInt();
                    Calendar data_licensa = Calendar.getInstance();
                    data_licensa.set(ano, mes, dia);
                    
                    System.out.println("Digite na seguinte ordem: nome, endereco, educacao, genero, classe economica, CPF");
                    entrada.nextLine();
                    nome = entrada.nextLine();
                    endereco = entrada.nextLine();
                    String educacao = entrada.nextLine();
                    String genero = entrada.nextLine();
                    String classeEconomica = entrada.nextLine();
                    String CPF = entrada.nextLine();
                    
                    ClientePF novoPF = new ClientePF(nome, endereco, data_licensa, educacao, 
                    genero, classeEconomica, listaVeiculos, CPF, data_nascimento);
                    AppMain.cadastrarClientePF(seg, novoPF);
                    break;
                
                case "PJ":
                    System.out.println("Digite o dia, mês e ano da data de fundacao nesta ordem");
                    dia = entrada.nextInt();
                    mes = entrada.nextInt();
                    ano = entrada.nextInt();
                    Calendar data_fundacao = Calendar.getInstance();
                    data_fundacao.set(ano, mes, dia);

                    System.out.println("Digite na seguinte ordem: nome, endereco, CNPJ, qtd de funcionarios");
                    entrada.nextLine();
                    nome = entrada.nextLine();
                    endereco = entrada.nextLine();
                    String CNPJ = entrada.nextLine();
                    int qtd_funcionarios = entrada.nextInt();

                    ClientePJ novoPJ = new ClientePJ(nome, endereco, listaVeiculos, CNPJ, 
                    data_fundacao, qtd_funcionarios);
                    AppMain.cadastrarClientePJ(seg, novoPJ);
                    break;

                default:
                    System.out.println("O valor digitado não corresponde com as opcoes");
                    break;
            }
                break;
            
            case CADASTRAR_VEICULO:
                existe = false;
                System.out.println("Qual cliente que o veiculo será adicionado?");
                entrada.nextLine();
                String cl = entrada.nextLine();

                for (Cliente c:seg.getListaClientes()){
                    if(c.getNome().equals(cl)){
                        cliente = c;
                        existe = true;
                        break;
                    }
                }             
                if (existe){
                    System.out.println("Digite na seguinte ordem: ano de fabricacao, placa, marca, modelo");
                    int anoFabricacao = entrada.nextInt();
                    entrada.nextLine();
                    String placa = entrada.nextLine();
                    String marca = entrada.nextLine();
                    String modelo = entrada.nextLine();
                    Veiculo n_veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                    cliente.getListaVeiculos().add(n_veiculo);
                    System.out.println("Veiculo cadastrado com sucesso");
                } else {
                    System.out.println("O cliente não existe");
                }
                break;
            
            case CADASTRAR_SEGURADORA:
                
                break;
            
            case LISTAR_CLIENTE_SEG:
                System.out.println("Imprimindo lista de clientes:");
                for (Cliente c:seg.getListaClientes()){
                    System.out.println(c.getNome()+" - ");
                    break;
                }
                break;

            case LISTAR_SINISTROS_SEG:
                for (Sinistro s:seg.getListaSinistros()){
                    System.out.println(s.toString());
                    System.out.println("*******************************");
                }
                break;
            
            case LISTAR_SINISTROS_CLIENTE:
                System.out.println("Qual o nome do cliente?");
                entrada.nextLine();
                nome = entrada.nextLine();

                for(Cliente c:seg.getListaClientes()){
                    if (c.getNome().equals(nome)){
                        cliente = c;
                        existe = true;
                        break;
                    }
                }
                List<Sinistro> listaSinistros = seg.listarSinistros(cliente);
                for (Sinistro s:listaSinistros)
                    System.out.println(s.toString());                
                break;

            case LISTAR_VEICULOS_CLIENTE:

                break;

            case LISTAR_VEICULOS_SEGURADORA:

                break;
            
            case EXCLUIR_CLIENTE:

                break;

            case EXCLUIR_SINISTRO:

                break;

            case EXCLUIR_VEICULO:

                break;

            case GERAR_SINISTRO:

                break;

            case TRANSFERIR_SEGURO:

                break;

            case CALCULAR_RECEITA_SEGURADORA:

                break;

            case SAIR:
                System.out.println("Encerrando o menu.");
                out = false;
                break;
        
            default:
                break;
        }

        return out;
    }
}
