package estacionamento.poov1.service;

import java.time.LocalDateTime;

import estacionamento.poov1.enums.TipoVeiculo;
import estacionamento.poov1.exception.VagaIndisponivelException;
import estacionamento.poov1.factory.VeiculoFactory;
import estacionamento.poov1.models.*;

public class EstacionamentoService {

    private Estacionamento estacionamento;

    public EstacionamentoService(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }

    public void cadastrarCliente(String nome, String cpf, String telefone) {

        Cliente cliente = new Cliente(nome, cpf, telefone);

        estacionamento.adicionarCliente(cliente);
    }

    public void cadastrarVaga(int numero) {

        Vaga vaga = new Vaga(numero);

        estacionamento.adicionarVaga(vaga);
    }

    public Veiculo cadastrarVeiculo(TipoVeiculo tipo, String placa, String modelo, String marca) {

        Veiculo veiculo = VeiculoFactory.criarVeiculo(tipo, placa, modelo, marca);

        estacionamento.adicionarVeiculo(veiculo);

        return veiculo;
    }

    public Ticket registrarEntrada(Veiculo veiculo) throws VagaIndisponivelException {

        return estacionamento.registrarEntrada(veiculo);
    }

    public void registrarSaida(Ticket ticket) {
        ticket.registrarSaida(LocalDateTime.now());

    }
}