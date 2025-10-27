package br.com.locadora.dao;

import br.com.locadora.model.Filme;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public Filme salvar(Filme filme) throws SQLException {
        String sql = "INSERT INTO filmes (titulo, categoria, ano, disponivel) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getCategoria());
            if (filme.getAno() == null) ps.setNull(3, Types.INTEGER);
            else ps.setInt(3, filme.getAno());
            ps.setBoolean(4, filme.isDisponivel());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    filme.setId(rs.getInt(1));
                }
            }
        }
        return filme;
    }

    public List<Filme> listar() throws SQLException {
        List<Filme> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, categoria, ano, disponivel FROM filmes";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Filme f = new Filme();
                f.setId(rs.getInt("id"));
                f.setTitulo(rs.getString("titulo"));
                f.setCategoria(rs.getString("categoria"));
                int ano = rs.getInt("ano");
                if (!rs.wasNull()) f.setAno(ano);
                f.setDisponivel(rs.getBoolean("disponivel"));
                lista.add(f);
            }
        }
        return lista;
    }

    public Filme buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, titulo, categoria, ano, disponivel FROM filmes WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Filme f = new Filme();
                    f.setId(rs.getInt("id"));
                    f.setTitulo(rs.getString("titulo"));
                    f.setCategoria(rs.getString("categoria"));
                    int ano = rs.getInt("ano");
                    if (!rs.wasNull()) f.setAno(ano);
                    f.setDisponivel(rs.getBoolean("disponivel"));
                    return f;
                }
            }
        }
        return null;
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM filmes WHERE id = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
