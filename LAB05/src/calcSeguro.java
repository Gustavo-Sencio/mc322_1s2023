public enum calcSeguro {
    VALOR_BASE(100),
    FATOR_0_30(1.25),
    FATOR_30_60(1.0),
    FATOR_60_150(1.5);

    private final double valor;

    calcSeguro(double valor){
        this.valor = valor;
    }

    public double valor(){
        return this.valor;
    }
}
