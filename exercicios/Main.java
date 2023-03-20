import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe um nome:");
        String nome = entrada.nextLine();  
        Aluno aluno = new Aluno(nome);

        aluno.imprimeAluno();
    }
}