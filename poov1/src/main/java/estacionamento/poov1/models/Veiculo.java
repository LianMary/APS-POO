package estacionamento.poov1.models;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String marca;

    public Veiculo() {
    }

    public Veiculo(String placa, String modelo, String marca) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
    }

    public abstract double calcularValorHora();

    public String getPlaca() {
        return placa;
    }
    public String getModelo() {
        return modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
