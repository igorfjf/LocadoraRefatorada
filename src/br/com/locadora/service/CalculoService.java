package br.com.locadora.service;

public class CalculoService {

    public double calcularValor(int quantidade, double precoUnitario) {
        if (quantidade < 0 || precoUnitario < 0) {
            throw new IllegalArgumentException("Valores não podem ser negativos");
        }
        return quantidade * precoUnitario;
    }
}
