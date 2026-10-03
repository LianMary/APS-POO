package estacionamento.poov1.models;

import estacionamento.poov1.enums.StatusTicket;
import estacionamento.poov1.interfaces.Calculavel;
import estacionamento.poov1.interfaces.EstrategiaTarifa;

import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket implements Calculavel{

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Vaga vaga;
    private double valor;
    private Veiculo veiculo;
    private StatusTicket status;

    private EstrategiaTarifa estrategiaTarifa;

    public Ticket(LocalDateTime entrada, Vaga vaga, Veiculo veiculo, EstrategiaTarifa estrategiaTarifa) {

        if (entrada == null) {
            throw new IllegalArgumentException("A entrada não pode ser nula.");
        }

        if (vaga == null) {
            throw new IllegalArgumentException("A vaga não pode ser nula.");
        }

        if (veiculo == null) {
            throw new IllegalArgumentException("O veículo não pode ser nulo.");
        }

        if (estrategiaTarifa == null) {
            throw new IllegalArgumentException("A estratégia de tarifa não pode ser nula.");
        }

        this.entrada = entrada;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.estrategiaTarifa = estrategiaTarifa;
        this.status = StatusTicket.ABERTO;
        this.valor = 0.0;
    }

    @Override
    public double calcularValor(long minutos) {

        if (minutos < 0) {
            throw new IllegalArgumentException("Os minutos não podem ser negativos.");
        }

        double horas = Math.ceil(minutos / 60.0);

        return estrategiaTarifa.calcular(horas);
    }

    public void registrarSaida(LocalDateTime saida) {

        if (status == StatusTicket.FECHADO) {
                throw new IllegalStateException("O ticket já está fechado.");
        }

        if (saida == null) {
            throw new IllegalArgumentException("A data de saída não pode ser nula.");
        }

        if (saida.isBefore(entrada)) {
                throw new IllegalArgumentException("A saída não pode ser anterior à entrada.");
        }

        this.saida = saida;

        long minutos = Duration.between(entrada, saida).toMinutes();

        this.valor = calcularValor(minutos);

        this.status = StatusTicket.FECHADO;

        vaga.liberar();
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public StatusTicket getStatus() {
        return status;
    }
}