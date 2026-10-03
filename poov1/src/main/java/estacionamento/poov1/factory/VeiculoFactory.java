package estacionamento.factory;

import estacionamento.enums.TipoVeiculo;
import estacionamento.model.Carro;
import estacionamento.model.Moto;
import estacionamento.model.Veiculo;

public class VeiculoFactory {

    public static Veiculo criarVeiculo(
            TipoVeiculo tipo,
            String placa,
            String modelo,
            String marca) {

        switch (tipo) {

            case CARRO:
                return new Carro(placa, modelo, marca);

            case MOTO:
                return new Moto(placa, modelo, marca);

            default:
                throw new IllegalArgumentException(
                        "Tipo de veículo inválido."
                );
        }
    }
}