package estacionamento.poov1.models;

public class Vaga {

    private int numero;
    private boolean ocupada;

    public Vaga(){

    }

    public Vaga(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public boolean estaOcupada() {
        return ocupada;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void liberar() {
        ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}