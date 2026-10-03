package estacionamento.model;

public class Carro extends Veiculo {

    public Carro(String placa, String modelo, String marca) {
        super(placa, modelo, marca);
    }

    @Override
    public double calcularValorHora() {
        return 10.0;
    }
}