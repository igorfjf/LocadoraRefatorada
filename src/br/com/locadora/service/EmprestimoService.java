package br.com.locadora.service;

import br.com.locadora.dao.EmprestimoDAO;
import br.com.locadora.model.Emprestimo;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {
    private final EmprestimoDAO dao = new EmprestimoDAO();

    public Emprestimo registrarEmprestimo(int clienteId, int filmeId, LocalDate data) throws SQLException {
        Emprestimo e = new Emprestimo();
        e.setClienteId(clienteId);
        e.setFilmeId(filmeId);
        e.setDataEmprestimo(data != null ? data : LocalDate.now());
        e.setDataDevolucao(null);
        return dao.salvar(e);
    }

    public List<Emprestimo> listar() throws SQLException {
        return dao.listar();
    }
}
