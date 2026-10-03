package estacionamento.strategy;

public class TarifaMoto implements EstrategiaTarifa {

    private static final double VALOR_HORA = 5.0;

    @Override
    public double calcular(double horas) {
        return horas * VALOR_HORA;
    }
}