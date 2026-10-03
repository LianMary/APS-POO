package estacionamento.service;

import estacionamento.enums.TipoVeiculo;
import estacionamento.exception.VagaIndisponivelException;
import estacionamento.factory.VeiculoFactory;
import estacionamento.model.*;
import estacionamento.strategy.*;

public class EstacionamentoService {

    private Estacionamento estacionamento;

    public EstacionamentoService(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public void cadastrarCliente(
            String nome,
            String cpf,
            String telefone) {

        Cliente cliente = new Cliente(
                nome,
                cpf,
                telefone
        );

        estacionamento.adicionarCliente(cliente);
    }

    public void cadastrarVaga(int numero) {

        Vaga vaga = new Vaga(numero);

        estacionamento.adicionarVaga(vaga);
    }

    public Veiculo cadastrarVeiculo(
            TipoVeiculo tipo,
            String placa,
            String modelo,
            String marca) {

        Veiculo veiculo = VeiculoFactory.criarVeiculo(
                tipo,
                placa,
                modelo,
                marca
        );

        return veiculo;
    }
}