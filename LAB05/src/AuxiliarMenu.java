public class AuxiliarMenu {
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
}
