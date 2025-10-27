package br.com.locadora.dao;

import br.com.locadora.model.Emprestimo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    public Emprestimo salvar(Emprestimo e) throws SQLException {
        String sql = "INSERT INTO emprestimos (cliente_id, filme_id, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, e.getClienteId());
            ps.setInt(2, e.getFilmeId());
            if (e.getDataEmprestimo() == null) ps.setNull(3, Types.DATE);
            else ps.setDate(3, Date.valueOf(e.getDataEmprestimo()));
            if (e.getDataDevolucao() == null) ps.setNull(4, Types.DATE);
            else ps.setDate(4, Date.valueOf(e.getDataDevolucao()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) e.setId(rs.getInt(1));
            }
        }
        return e;
    }

    public List<Emprestimo> listar() throws SQLException {
        List<Emprestimo> lista = new ArrayList<>();
        String sql = "SELECT id, cliente_id, filme_id, data_emprestimo, data_devolucao FROM emprestimos";
        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Emprestimo e = new Emprestimo();
                e.setId(rs.getInt("id"));
                e.setClienteId(rs.getInt("cliente_id"));
                e.setFilmeId(rs.getInt("filme_id"));
                Date dt = rs.getDate("data_emprestimo");
                if (dt != null) e.setDataEmprestimo(dt.toLocalDate());
                Date dv = rs.getDate("data_devolucao");
                if (dv != null) e.setDataDevolucao(dv.toLocalDate());
                lista.add(e);
            }
        }
        return lista;
    }
}
