package estacionamento.poov1.factory;

import estacionamento.poov1.enums.TipoVeiculo;
import estacionamento.poov1.models.Carro;
import estacionamento.poov1.models.Moto;
import estacionamento.poov1.models.Veiculo;

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