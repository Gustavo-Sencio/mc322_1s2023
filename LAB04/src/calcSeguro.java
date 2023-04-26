public enum calcSeguro {
    VALOR_BASE(100),
    FATOR_18_30(1.2),
    FATOR_30_60(1.0),
    FATOR_60_90(1.5);

    private final double valor;

    calcSeguro(double valor){
        this.valor = valor;
    }

    public double valor(){
        return this.valor;
    }
}
