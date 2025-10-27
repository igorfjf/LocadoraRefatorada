package br.com.locadora.model;

import java.time.LocalDate;

public class Emprestimo {
    private Integer id;
    private Integer clienteId;
    private Integer filmeId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getClienteId() { return clienteId; }
    public void setClienteId(Integer clienteId) { this.clienteId = clienteId; }

    public Integer getFilmeId() { return filmeId; }
    public void setFilmeId(Integer filmeId) { this.filmeId = filmeId; }

    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", filmeId=" + filmeId +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
