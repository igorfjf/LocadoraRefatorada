package br.com.locadora.model;

public class Filme {
    private Integer id;
    private String titulo;
    private String categoria;
    private Integer ano;
    private boolean disponivel;

    public Filme() {}

    public Filme(Integer id, String titulo, String categoria, Integer ano, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.ano = ano;
        this.disponivel = disponivel;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", ano=" + ano +
                ", disponivel=" + disponivel +
                '}';
    }
}
