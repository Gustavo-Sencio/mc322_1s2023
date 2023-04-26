public class Validacao {
    public static boolean validarCPF(String CPF){
        CPF = CPF.replaceAll("[^0-9]+", ""); //Tirando os caracteres não numéricos
        if (CPF.length() != 11) //Verificando se o CPF possui 11 caracteres
            return false;

        //Verificando se todos os caracteres são iguais
        int i;
        char ant = CPF.charAt(0);
        boolean verificador = true; //Se o verificador permanecer true apos o for é porque todos os caracteres são iguais

        for (i = 1; i != 11; i++){
            if (ant != CPF.charAt(i)){
                verificador = false;
                break;
            }
            ant = CPF.charAt(i);
        }

        if (verificador)
            return false;

        //Validando os numeros no cpf

        //Calculo do 1º digito verificador
        char d10, d11;
        int soma = 0, resto, n, peso = 10;

        //Primeiro eu vou converter os caracteres do cpf em int e após fazer o calculo com o peso correspondente
        for(i = 0; i<9; i++){
            n = (CPF.charAt(i)) - 48;
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
            n = (CPF.charAt(i)) - 48;
            soma = soma + (n * peso);
            peso--;
        }

        resto = 11 - (soma%11);
        if ((resto == 11) || (resto == 10))
            d11 = '0';
        else d11 = (char)(resto + 48);

        //Verificando se os digitos do CPF conferem com os digitos calculados
        if((d10 == CPF.charAt(9)) && (d11 == CPF.charAt(10)))
            return true;
        else return false;
    }

    public static boolean validarCNPJ(String CNPJ){
        CNPJ = CNPJ.replaceAll("[^0-9]+", ""); //Tirando os caracteres não numéricos
        if (CNPJ.length() != 14) //Verificando se o CNPJ possui 11 caracteres
            return false;

        //Verificando se todos os caracteres são iguais
        int i;
        char ant = CNPJ.charAt(0);
        boolean verificador = true; //Se o verificador permanecer true apos o for é porque todos os caracteres são iguais

        for (i = 1; i != 14; i++){
            if (ant != CNPJ.charAt(i)){
                verificador = false;
                break;
            }
            ant = CNPJ.charAt(i);
        }

        if (verificador)
            return false;
        
        //Validando os numeros no CNPJ

        char d13, d14;
        int soma, resto, n, peso;

        // Calculo do 1o. Digito Verificador
        soma = 0;
        peso = 2;

        //Coverter os caracteres em int e após fazer o calculo com o peso
        for (i = 11; i>=0; i--){
            n = (int)(CNPJ.charAt(i) - 48);
            soma = soma + (n * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        resto = soma%11;
        if ((resto == 0) || (resto == 1))
            d13 = '0';
        else
            d13 = (char)((11-resto) + 48);
            
        // Calculo do 2o. Digito Verificador
        soma = 0;
        peso = 2;

        for (i = 12; i>=0; i--){
            n = (int)(CNPJ.charAt(i) - 48);
            soma = soma + (n * peso);
            peso = peso + 1;
            if (peso == 10)
                peso = 2;
        }

        resto = soma%11;
        if ((resto == 0) || (resto == 1))
            d14 = '0';
        else
            d14 = (char)((11-resto) + 48);
            
        //Verificando se os digitos do CPF conferem com os digitos calculados
        if((d13 == CNPJ.charAt(12)) && (d14 == CNPJ.charAt(13)))
            return true;
        else 
            return false;
    }

    public static boolean validarNome(String nome){
        for(int i = 0; i < nome.length(); i++){
            if(!Character.isAlphabetic(nome.charAt(i)))
                return false;
        
        }
        return true;
    }
}
