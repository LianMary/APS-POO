package estacionamento.poov1.strategy;

import estacionamento.poov1.interfaces.EstrategiaTarifa;

public class TarifaCarro implements EstrategiaTarifa {

    private static final double VALOR_HORA = 10.0;

    @Override
    public double calcular(double horas) {
        return horas * VALOR_HORA;
    }
}