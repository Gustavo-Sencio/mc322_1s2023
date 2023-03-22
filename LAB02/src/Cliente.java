public class Cliente{
    private String nome;
    private String CPF;
    private String dataNascimento;
    private int idade;
    private String endereco;

    //Construtor
    public Cliente(String nome, String CPF, String dataNascimento, int idade, String endereco){
        this.nome = nome;
        this.CPF = CPF.replaceAll("[^0-9]+", "");
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
        int i;
        char ant = this.CPF.charAt(0);;
        boolean verificador = true; //Se o verificador permanecer true apos o for é porque todos os caracteres são iguais

        for (i = 1; i != 11; i++){
            if (ant != this.CPF.charAt(i)){
                verificador = false;
                break;
            }
            ant = this.CPF.charAt(i);
        }

        if (verificador)
            return false;

        //Validando os numeros no cpf

        //Calculo do 1º digito verificador
        char d10, d11;
        int soma = 0, resto, n, peso = 10;

        //Primeiro eu vou converter os caracteres do cpf em int e após fazer o calculo com o peso correspondente
        for(i = 0; i<9; i++){
            n = (this.CPF.charAt(i)) - 48;
            soma = soma + (n * peso);
            peso--;
        }

        resto = 11 - (soma%11);
        if((resto == 11) || (resto == 10))
            d10 = '0';
        else d10 = (char)(resto + 48);

        //Calculo do 2º digito verificador
        soma = 0;
        peso = 11;
        for (i = 0; i<10; i++){
            n = (this.CPF.charAt(i)) - 48;
            soma = soma + (n * peso);
            peso--;
        }

        resto = 11 - (soma%11);
        if ((resto == 11) || (resto == 10))
            d11 = '0';
        else d11 = (char)(resto + 48);

        //Verificando se os digitos do CPF conferem com os digitos calculados
        if((d10 == this.CPF.charAt(9)) && (d11 == this.CPF.charAt(10)))
            return true;
        else return false;
    }
}