import java.util.Scanner;

public class Aluno{
    private String nome;
    private int matricula;
    private int idade;
    private float altura;

    public Aluno(){
        this.nome = "Fulano de tal";
        this.matricula = 000000;
        this.idade = 0;
    }
    
    public Aluno(String nome){
        this.nome = nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setAltura(float altura){
        this.altura = altura;
    }

    public void imprimeAluno(){
        System.out.printf("NOME: %s\nMATRICULA: %d\nIDADE: %d\nAltura: %f\n", this.nome, this.matricula, this.idade, this.altura);
    }
}