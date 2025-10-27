package br.com.locadora.service;

import br.com.locadora.dao.FilmeDAO;
import br.com.locadora.model.Filme;
import java.sql.SQLException;
import java.util.List;

public class FilmeService {

    private final FilmeDAO dao = new FilmeDAO();

    public Filme cadastrar(Filme filme) throws SQLException {
        if (filme.getTitulo() == null || filme.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("Título do filme é obrigatório");
        }
        if (filme.getCategoria() == null) filme.setCategoria("");
        if (filme.getAno() == null) filme.setAno(null);
        filme.setDisponivel(true);
        return dao.salvar(filme);
    }

    public List<Filme> listar() throws SQLException {
        return dao.listar();
    }

    public boolean excluir(int id) throws SQLException {
        return dao.excluir(id);
    }

    public Filme buscarPorId(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
}
