package estacionamento.model;

public class Moto extends Veiculo {

    public Moto(String placa, String modelo, String marca) {
        super(placa, modelo, marca);
    }

    @Override
    public double calcularValorHora() {
        return 5.0;
    }
}