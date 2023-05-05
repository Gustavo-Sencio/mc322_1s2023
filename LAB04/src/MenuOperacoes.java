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
        Veiculo veiculo = new Veiculo();

        switch (menu) {
            case CADASTRAR_CLIENTE:
            //entrada.nextLine();
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
            
            case CADASTRAR_VEICULO: //alterar indice
                existe = false;
                System.out.println("Qual cliente que o veiculo será adicionado?");
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
                AppMain.atualizar_valores(seg);
                break;
            
            case CADASTRAR_SEGURADORA:
                
                break;
            
            case LISTAR_CLIENTE_SEG:
                System.out.println("Imprimindo lista de clientes:");
                for (Cliente c:seg.getListaClientes()){
                    System.out.println(c.getNome()+" - ");
                }
                break;

            case LISTAR_SINISTROS_SEG:
                for (Sinistro s:seg.getListaSinistros()){
                    System.out.println(s.toString());
                    System.out.println("*******************************");
                }
                break;
            
            case LISTAR_SINISTROS_CLIENTE:
                existe = false;
                System.out.println("Qual o nome do cliente?");
                nome = entrada.nextLine();

                for(Cliente c:seg.getListaClientes()){
                    if (c.getNome().equals(nome)){
                        cliente = c;
                        existe = true;
                        break;
                    }
                }
                if (existe){
                    List<Sinistro> listaSinistros = seg.listarSinistros(cliente);
                    for (Sinistro s:listaSinistros)
                        System.out.println(s.toString());
                        System.out.println("****************"); 
                } else {
                    System.out.println("O cliente não existe");           
                }
                break;

            case LISTAR_VEICULOS_CLIENTE:
                existe = false;
                System.out.println("Qual o nome do cliente?");
                nome = entrada.nextLine();

                for(Cliente c:seg.getListaClientes()){
                    if (c.getNome().equals(nome)){
                        cliente = c;
                        existe = true;
                        break;
                    }
                }
                if (existe){
                    List<Veiculo> l_Veiculos = cliente.getListaVeiculos();
                    for (Veiculo v:l_Veiculos)
                        System.out.println(v.toString());
                        System.out.println("****************");
                } else{
                    System.out.println("O cliente não existe");
                }
                break;

            case LISTAR_VEICULOS_SEGURADORA:
                for (Cliente c:seg.getListaClientes()){
                    for (Veiculo v:c.getListaVeiculos()){
                        System.out.println(v.toString());
                        System.out.println("****************");
                    }
                }
                break;
            
            case EXCLUIR_CLIENTE:
                System.out.println("Qual o nome do cliente?");
                nome = entrada.nextLine();
                boolean ok = seg.removerCliente(nome);
                if (ok){
                    System.out.println("O cliente foi removido com sucesso!");
                } else {
                    System.out.println("O cliente não existe!");
                }
                break;

            case EXCLUIR_SINISTRO:
                existe = false;
                System.out.println("Qual o id do sinistro?");
                int n = entrada.nextInt();
                for (int i = 0; i < seg.getListaSinistros().size(); i++){
                    if (seg.getListaSinistros().get(i).getId() == n){
                        existe = true;
                        seg.getListaSinistros().remove(i);
                        break;
                    }
                }
                if (existe)
                    System.out.println("Sinistro removido!");
                else
                    System.out.println("Sinistro nao existe!");
                break;

            case EXCLUIR_VEICULO: //Alterar indice
                existe = false;
                System.out.println("Qual a placa do veiculo?");
                nome = entrada.nextLine();
                for (Cliente c:seg.getListaClientes()){
                    for (int i = 0; i < c.getListaVeiculos().size(); i++){
                        if (c.getListaVeiculos().get(i).getPlaca().equals(nome)){
                            existe = true;
                            c.getListaVeiculos().remove(i);
                            break;
                        }
                    }
                }
                if (existe)
                    System.out.println("Veiculo removido com sucesso!");
                else
                    System.out.println("Veiculo não existe!");
                AppMain.atualizar_valores(seg);
                break;

            case GERAR_SINISTRO:
                System.out.println("Qual é o cliente do sinistro?");
                nome = entrada.nextLine();
                System.out.println("Qual é a placa do veiculo do sinistro?");
                String Placa = entrada.nextLine();

                for (Cliente c: seg.getListaClientes()){
                    if (c.getNome().equals(nome)){
                        cliente = c;
                        break;
                    }
                }

                for (Veiculo v:cliente.getListaVeiculos()){
                    if (v.getPlaca().equals(Placa)){
                        veiculo = v;
                        break;
                    }
                }

                boolean Ok = seg.gerarSinistro(cliente, veiculo);
                if (Ok)
                    System.out.println("Sinistro gerado com sucesso");
                else
                    System.out.println("Falha ao gerar sinistro");
                break;

            case TRANSFERIR_SEGURO:
                boolean existe_nome1 = false, existe_nome2 = false;
                int indice1 = 0, indice2 = 0;
                System.out.println("Qual é o nome do cliente que vai transferir o seguro?");
                String nome1 = entrada.nextLine();
                System.out.println("Qual é o nome do cliente que vai receber os veiculos?");
                String nome2 = entrada.nextLine();

                for (int i = 0; i < seg.getListaClientes().size(); i++){
                    if (seg.getListaClientes().get(i).getNome().equals(nome1)){
                        indice1 = i;
                        existe_nome1 = true;
                    }
                    if (seg.getListaClientes().get(i).getNome().equals(nome2)){
                        indice2 = i;
                        existe_nome2 = true;
                    }
                }

                if (existe_nome1 && existe_nome2){
                    List<Veiculo> listaVeiculos1 = seg.getListaClientes().get(indice1).getListaVeiculos();
                    for (Veiculo v:listaVeiculos1)
                        seg.getListaClientes().get(indice2).getListaVeiculos().add(v); //Adicionando os veiculos em cliente 2
                    
                    List<Veiculo> listaNova = new ArrayList<Veiculo>();
                    seg.getListaClientes().get(indice1).setListaVeiculos(listaNova); //Excluindo a lista do cliente 1

                    seg.getListaClientes().get(indice1).setValorSeguro(seg.calcularPrecoSeguroCliente(seg.getListaClientes().get(indice1))); // Calculando o novo valor do seguro do cliente 1
                    seg.getListaClientes().get(indice2).setValorSeguro(seg.calcularPrecoSeguroCliente(seg.getListaClientes().get(indice2))); // Calculando o novo valor do seguro do cliente 2
                    System.out.println("Transferencia de seguro concluida");
                } else {
                    System.out.println("Os dois ou algum dos clientes não existe!");
                }
                break;

            case CALCULAR_RECEITA_SEGURADORA:
                seg.calcularReceita();
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