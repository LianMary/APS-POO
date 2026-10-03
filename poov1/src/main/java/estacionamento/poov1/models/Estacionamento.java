package estacionamento.poov1.models;

import estacionamento.poov1.exception.VagaIndisponivelException;

import java.util.*;

public class Estacionamento {

    private List<Ticket> tickets;
    private Map<Integer, Vaga> vagas;
    private Set<Veiculo> veiculos;
    private List<Cliente> clientes;

    public Estacionamento() {

        tickets = new ArrayList<>();
        vagas = new HashMap<>();
        veiculos = new HashSet<>();
        clientes = new ArrayList<>();
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.put(vaga.getNumero(), vaga);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Vaga> consultarVagasDisponiveis() {

        List<Vaga> disponiveis = new ArrayList<>();

        for (Vaga vaga : vagas.values()) {

            if (!vaga.estaOcupada()) {
                disponiveis.add(vaga);
            }
        }

        return disponiveis;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public Ticket registrarEntrada(Veiculo veiculo)
        throws VagaIndisponivelException {

    Vaga vaga = encontrarVagaDisponivel();

    vaga.ocupar();

    Ticket ticket = new Ticket(veiculo, vaga);

    tickets.add(ticket);

    return ticket;
}

    private Vaga encontrarVagaDisponivel() throws VagaIndisponivelException {
        
        for ( Vaga vaga : vagas.values()) {

            if (!vaga.estaOcupada()) {
                return vaga;
            }
        }

        throw new VagaIndisponivelException(
                "Não existem vagas disponíveis."
        );
    }
}