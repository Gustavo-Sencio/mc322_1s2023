package menus;
public enum Listar {
    LISTAR_CLIENTE_SEG(1),
    LISTAR_SINISTROS_SEG(2),
    LISTAR_SINISTROS_CLIENTE(3),
    LISTAR_VEICULOS_CLIENTE(4),
    LISTAR_VEICULO_SEGURADORA(5),
    VOLTAR(6);

    private final int operacao;

    Listar(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }
}
