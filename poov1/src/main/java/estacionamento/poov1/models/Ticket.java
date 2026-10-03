package estacionamento.poov1.models;

import estacionamento.poov1.enums.StatusTicket;
import estacionamento.poov1.interfaces.EstrategiaTarifa;

import java.time.LocalDateTime;

public class Ticket {

    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Vaga vaga;
    private double valor;
    private Veiculo veiculo;
    private StatusTicket status;

    private EstrategiaTarifa estrategiaTarifa;

    public Ticket(Veiculo veiculo, Vaga vaga) {
    this.veiculo = veiculo;
    this.vaga = vaga;
    }

    public Ticket(LocalDateTime entrada, Vaga vaga, Veiculo veiculo, EstrategiaTarifa estrategiaTarifa) {

        this.entrada = entrada;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.estrategiaTarifa = estrategiaTarifa;
        this.status = StatusTicket.ABERTO;
        this.valor = 0.0;
    }

    public double calcularValor(long minutos) {

        double horas = Math.ceil(minutos / 60.0);

        return estrategiaTarifa.calcular(horas);
    }

    public void registrarSaida(LocalDateTime saida) {

        this.saida = saida;

        long minutos = java.time.Duration
                .between(entrada, saida)
                .toMinutes();

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

    public void registrarSaida(
            Ticket ticket) {

        ticket.registrarSaida(
                java.time.LocalDateTime.now()
        );
    }
}