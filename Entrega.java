package com.mycompany.appdelivery;
public class Entregador extends Pessoa {
    private String veiculo;

    public Entregador(int telefone, String nome, String endereco, String veiculo, int par1) {
        super(nome, endereco, telefone);
        this.veiculo = veiculo;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        if (veiculo == null || veiculo.isEmpty()) {
            throw new IllegalArgumentException("Veículo não pode ser nulo ou vazio.");
        }
        this.veiculo = veiculo;
    }

    public void realizarEntrega() {
        System.out.println("Entrega realizada com sucesso pelo entregador: " + getNome());
    }

    @Override
    public String toString() {
        return "Entregador: " + getNome() + " (Veículo: " + veiculo + ")";
    }
}
