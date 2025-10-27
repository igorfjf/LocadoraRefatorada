package br.com.locadora.service;

import br.com.locadora.dao.ClienteDAO;
import br.com.locadora.model.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteService {
    private final ClienteDAO dao = new ClienteDAO();

    public Cliente cadastrar(Cliente c) throws SQLException {
        if (c.getNome() == null || c.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente é obrigatório");
        }
        return dao.salvar(c);
    }

    public List<Cliente> listar() throws SQLException {
        return dao.listar();
    }
}
