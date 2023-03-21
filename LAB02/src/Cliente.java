public class Cliente{
    private String nome;
    private String CPF;
    private String dataNascimento;
    private int idade;
    private String endereco;

    //Construtor
    public Cliente(String nome, String CPF, String dataNascimento, int idade, String endereco){
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    //Setters e getters
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return this.CPF;
    }

    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public boolean validarCPF(){
        this.CPF = this.CPF.replaceAll("[^0-9]+", ""); //Tirando os caracteres não numéricos
        if (this.CPF.length() != 11) //Verificando se o CPF possuio 11 caracteres
            return false;

        //Verificando se todos os caracteres são iguais
        char ant = this.CPF[0];
        boolean verificador = true; //Se o verificador permanecer true apos o for é porque todos os caracteres são iguais
        for (int i = 1; i != 11; i++){
            if (ant != this.CPF[i]){
                verificador = false;
                break;
            }
            ant = this.CPF[i];
        }

        if (verificador)
            return false;

        //Conferir cpf
    }
}