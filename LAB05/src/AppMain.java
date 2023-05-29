import java.util.*;

public class AppMain {
    public static void main(String[] args) throws Exception {
        //Criando uma seguradora
        Seguradora seg = new Seguradora("63.705.179/0001-00","Direcao responsavel", "(19)98702-2149",
        "Direcaoresp@gmail.com", "Jardim Capivari");

        //Criando uma lista de frota para criar um cliente PJ
        Veiculo v1 = new Veiculo("HPT-7253", "BMW", "335iA", 2014);
        Veiculo v2 = new Veiculo("GQS-9683", "Ford", "Escort Ghia", 1993);
        Frota f1 = new Frota("SUL-34");
        f1.addVeiculo(v2);
        f1.addVeiculo(v1);

        Veiculo v3 = new Veiculo("LSJ-5205", "smart", "fortwo passion coup", 2008);
        Frota f2 = new Frota("SUL-30");
        f2.addVeiculo(v3);

        List<Frota> listaFrota = new ArrayList<Frota>();
        listaFrota.add(f1);
        listaFrota.add(f2);

        //Criando um cliente PJ
        Calendar dataFundacao = Calendar.getInstance();
        dataFundacao.set(2014, 12, 4);
        ClientePJ clientePJ = new ClientePJ("Suprema", "Rua Senador Nilo Coelho",
         "(11) 3587-8065", "Suprema@gmail.com", "87.647.025/0001-60", dataFundacao, listaFrota);

        //Criando um cliente PF
        Veiculo v4 = new Veiculo("NDM-3626", "Asia Motors", "Towner SDX / DLX/ Std.", 1993);
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(2002, 9, 12);
        List<Veiculo> listaVeiculo = new ArrayList<Veiculo>();
        listaVeiculo.add(v4);
        ClientePF clientePF = new ClientePF("Aline Jéssica Luna da Cruz", "Rua C", "(35) 3608-0244", "aline_jessica_dacruz@fosjc.unesp.br", "Superior", "Feminino", "627.532.573-96", dataNascimento, listaVeiculo);

        //Criando 3 condutores, um é a aline e os outros dois é para a empresa suprema
        Condutor c1 = new Condutor(clientePF.getCPF(), clientePF.getNome(), clientePF.getTelefone(), clientePF.getEndereco(), clientePF.getEmail(), clientePF.getDataNascimento());
        dataNascimento.set(1971, 5, 28);
        Condutor c2 = new Condutor("747.927.388-65", "Manuela Isadora Santos", "(41) 3720-0011", "Rua Mário Lazarotto", "manuela.isadora.santos@bat.com", dataNascimento);
        dataNascimento.set(1976, 2, 3);
        Condutor c3 = new Condutor("135.114.574-67", "Edson Benício Castro", "(69) 3782-7881", "Rua Itatiaia", "edson_benicio_castro@jsagromecanica.com.br", dataNascimento);

        //Cadastrando a Aline e a empresa Suprema na seguradora
        seg.cadastrarCliente(clientePF);
        seg.cadastrarCliente(clientePJ);
        System.out.println(seg.toString());
        System.out.println("-----------------------------------------");

        //Criando os seguros respectivos
        seg.gerarSeguro(clientePF, v4);
        seg.gerarSeguro(clientePJ, f1);
        seg.gerarSeguro(clientePJ, f2);
        System.out.println(seg.toString());
        System.out.println("-----------------------------------------");

    }
}
