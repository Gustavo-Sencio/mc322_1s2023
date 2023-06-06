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
            "13 - Cadastrar Veiculo-Frota\n"+
            "14 - Cadastrar Frota\n"+
            "15 - Autorizar Condutor\n"+
            "16 - Gerar Seguro\n"+
            "17 - Gerar sinistro\n"+
            "21 - Listar clientes da seguradora\n"+
            "22 - Listar seguros da seguradora\n"+
            "23 - Listar seguros do cliente\n"+
            "24 - Listar sinistros do cliente\n"+
            "31 - Excluir cliente\n"+
            "32 - Excluir seguro\n"+
            "33 - Excluir veiculo da frota\n"+
            "34 - Excluir veiculo clientePF\n"+
            "4 - Calcular Receita Seguradora\n"+
            "0 - Encerrar menu");
            input = entrada.nextInt();
            loop = Menu.processarEntrada(input, seg);
            System.out.println("*************************************");
        }
    }

    public static boolean processarEntrada(int input, Seguradora seg){
        Scanner entrada = new Scanner(System.in);
        List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        List<Frota> listaFrota = new ArrayList<Frota>();
        int dia, mes, ano, id;
        Calendar data1 = Calendar.getInstance();
        String nome, endereco, telefone, email, code, placa;
        boolean out = true, existe;
        ClientePF clientePF = new ClientePF();
        ClientePJ clientePJ = new ClientePJ();
        Veiculo veiculo = new Veiculo();
        Frota frota = new Frota("XXXX");

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
                    placa = entrada.nextLine();
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
                existe = false;
                System.out.println("Qual o code da frota que o veiculo será adicionado?");
                code = entrada.nextLine();

                for (Cliente c:seg.getListaClientes()){
                    if(c instanceof ClientePJ){
                        for (Frota f:((ClientePJ)c).getListaFrota()){
                            if(f.getCode().equals(code)){
                                frota = f;
                                existe = true;
                                break;
                            }
                        }
                    }
                }

                if (existe){
                    System.out.println("Digite na seguinte ordem: Ano de fabricacao, placa, marca, modelo");
                    int anoFabricacao = entrada.nextInt();
                    entrada.nextLine();
                    placa = entrada.nextLine();
                    String marca = entrada.nextLine();
                    String modelo = entrada.nextLine();
                    Veiculo n_veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                    frota.addVeiculo(n_veiculo);
                    System.out.println("Veiculo cadastrado com sucesso");
                } else {
                    System.out.println("A frota não existe");
                }
                break;

            case 14:
                existe = false;
                System.out.println("Qual cliente que a frota será criada?");
                String cliente = entrada.nextLine();

                for (Cliente c:seg.getListaClientes()){
                    if(c.getNome().equals(cliente)){
                        clientePJ = (ClientePJ)c;
                        existe = true;
                        break;
                    }
                }             

                if(existe){
                    System.out.println("Primeiro iremos criar o veiculo para adicionar na frota");
                    System.out.println("Digite na seguinte ordem: Ano de fabricacao, placa, marca, modelo");
                    int anoFabricacao = entrada.nextInt();
                    entrada.nextLine();
                    placa = entrada.nextLine();
                    String marca = entrada.nextLine();
                    String modelo = entrada.nextLine();
                    Veiculo n_veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

                    System.out.println("Qual o código da frota?");
                    code = entrada.nextLine();
                    List<Veiculo> novaLista = new ArrayList<Veiculo>();
                    novaLista.add(n_veiculo);
                    Frota f1 = new Frota(code, novaLista);
                    clientePJ.cadastrarFrota(f1);
                    System.out.println("Frota cadastrada com sucesso");
                }
                else{
                    System.out.println("Não foi possivel cadastrar");
                }
                break;

            case 15:
                existe = false;
                System.out.println("Qual o id do seguro?");
                id = entrada.nextInt();
                for (Seguro s:seg.getListaSeguros()){
                    if (s.getId() == id){
                        existe = true;
                        System.out.println("Digite o dia, mês e ano de nascimento nesta ordem");
                        dia = entrada.nextInt();
                        mes = entrada.nextInt();
                        ano = entrada.nextInt();
                        data1.set(ano, mes, dia);
                        
                        System.out.println("Digite na seguinte ordem: nome, endereco, telefone, email, CPF");
                        entrada.nextLine();
                        nome = entrada.nextLine();
                        endereco = entrada.nextLine();
                        telefone = entrada.nextLine();
                        email = entrada.nextLine();
                        String CPF = entrada.nextLine();
                        Condutor novoCondutor = new Condutor(CPF, nome, telefone, endereco, email, data1);
                        s.autorizarCondutor(novoCondutor);
                    }
                }
                if (existe){
                    System.out.println("Condutor cadastrado com sucesso");
                }
                else{
                    System.out.println("Não foi possivle cadastrar o condutor");
                }
                break;

            case 16:
                System.out.println("PF ou PJ?");
                String string = entrada.nextLine();
                existe = false;
                
                switch (string) {
                    case "PF":
                        System.out.println("Qual o nome do cliente e a placa do veiculo?");
                        nome = entrada.nextLine();
                        placa = entrada.nextLine();

                        for (Cliente c:seg.getListaClientes()){
                            if (c.getNome().equals(nome)){
                                clientePF = (ClientePF)c;
                                break;
                            }
                        }
                        for (Veiculo v:clientePF.getListaVeiculos()){
                            if (v.getPlaca().equals(placa)){
                                veiculo = v;
                                existe = true;
                                break;
                            }
                        }

                        if(existe){
                            seg.gerarSeguro(clientePF, veiculo);
                            System.out.println("Seguro gerado com sucesso");
                        }
                        else{
                            System.out.println("Não foi possivel gerar o seguro");
                        }
                        break;
                    
                    case "PJ":
                        System.out.println("Qual o nome do cliente e o codigo da frota?");
                        nome = entrada.nextLine();
                        code = entrada.nextLine();

                        for (Cliente c:seg.getListaClientes()){
                            if (c.getNome().equals(nome)){
                                clientePJ = (ClientePJ)c;
                                break;
                            }
                        }
                        for (Frota f:clientePJ.getListaFrota()){
                            if (f.getCode().equals(code)){
                                frota = f;
                                existe = true;
                                break;
                            }
                        }
                        if(existe){
                            seg.gerarSeguro(clientePJ, frota);
                            System.out.println("Seguro gerado com sucesso");
                        }
                        else{
                            System.out.println("Não foi possivel gerar o seguro");
                        }
                        break;

                    default:
                        System.out.println("O valor digitado não corresponde com as opcoes");
                        break;
            }
                break;

            case 17:
                existe = false;
                System.out.println("Qual o id do seguro?");
                id = entrada.nextInt();
                for (Seguro s:seg.getListaSeguros()){
                    if (s.getId() == id){
                        System.out.println("Qual o nome do condutor?");
                        entrada.nextLine();
                        nome = entrada.nextLine();
                        for (Condutor c:s.getListaCondutores()){
                            if (c.getNome().equals(nome)){
                                existe = true;
                                System.out.println("Digite o dia, mês e ano do sinistro nesta ordem");
                                dia = entrada.nextInt();
                                mes = entrada.nextInt();
                                ano = entrada.nextInt();
                                data1.set(ano, mes, dia);
                                System.out.println("Qual o endereco?");
                                entrada.nextLine();
                                endereco = entrada.nextLine();
                                s.gerarSinistro(data1, endereco, c);
                            }
                        }
                    }
                }

                if (existe){
                    System.out.println("Sinistro gerado com sucesso");
                }
                else{
                    System.out.println("Impossivel gerar o sinistro");
                }
                break;
            
            case 21:
                for(Cliente c:seg.getListaClientes()){
                    System.out.println(c.toString());
                    System.out.println("-------------------------------------");
                }
                break;

            case 22:
                for(Seguro s:seg.getListaSeguros()){
                    System.out.println(s.toString());
                    System.out.println("-------------------------------------");
                }
                break;                

            case 23:
                System.out.println("Qual o nome do cliente");
                nome = entrada.nextLine();
                for (Cliente c:seg.getListaClientes()){
                    if (c.getNome().equals(nome)){
                        System.out.println(seg.getSegurosPorCliente(c));
                    }
                }
                break;
            
            case 24:
                System.out.println("Qual o nome do cliente");
                nome = entrada.nextLine();
                for (Cliente c:seg.getListaClientes()){
                    if (c.getNome().equals(nome)){
                        System.out.println(seg.getSinistrosPorCliente(c));
                    }
                }
                break;

            case 31:
                System.out.println("Qual o nome do cliente?");
                nome = entrada.nextLine();
                boolean ok = seg.removerCliente(nome);
                if (ok){
                    System.out.println("O cliente foi removido com sucesso!");
                } else {
                    System.out.println("O cliente não existe!");
                }
                break;

            case 32:
                System.out.println("Qual o id do seguro?");
                id = entrada.nextInt();
                existe = seg.cancelarSeguro(id);
                if (existe){
                    System.out.println("O seguro foi removido com sucesso!");
                } else {
                    System.out.println("O seguro não existe!");
                }
                break;

            case 33:
                System.out.println("Qual a placa do veiculo?");
                placa = entrada.nextLine();
                for (Cliente c:seg.getListaClientes()){
                    if (c instanceof ClientePJ){
                        for (Frota f:((ClientePJ)c).getListaFrota()){
                            f.removerVeiculo(placa);
                        }
                    }
                }
                System.out.println("Veiculo foi removido das frotas em que ele estava presente");
                break;

            case 34:
                System.out.println("Qual a placa do veiculo?");
                placa = entrada.nextLine();
                for (Cliente c:seg.getListaClientes()){
                    if (c instanceof ClientePF){
                        ((ClientePF)c).removerVeiculo(placa);
                    }
                }
                System.out.println("Veiculo foi removido dos clientes em que ele estava presente");
                break;

            case 4:
                System.out.println(seg.calcularReceita());
                break;
            
            case 0:
                System.out.println("Encerrando o menu.");
                out = false;
                break;

            default:
                System.out.println("O valor digitado não corresponde com as opcoes");
                break;
        }

        return out;
    }
}