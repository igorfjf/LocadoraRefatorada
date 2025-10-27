package br.com.locadora.app;

import br.com.locadora.model.Filme;
import br.com.locadora.model.Cliente;
import br.com.locadora.service.FilmeService;
import br.com.locadora.service.ClienteService;
import br.com.locadora.service.EmprestimoService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTES: Locadora Refatorada ===");

        FilmeService fs = new FilmeService();
        ClienteService cs = new ClienteService();
        EmprestimoService es = new EmprestimoService();

        try {
            // Cadastrar cliente
            Cliente c = new Cliente();
            c.setNome("Aluno Teste");
            c.setTelefone("(11) 99999-9999");
            c = cs.cadastrar(c);
            System.out.println("Cliente cadastrado: " + c);

            // Cadastrar filmes
            Filme f1 = new Filme();
            f1.setTitulo("Matrix");
            f1.setCategoria("Sci-Fi");
            f1.setAno(1999);
            f1 = fs.cadastrar(f1);
            System.out.println("Filme cadastrado: " + f1);

            Filme f2 = new Filme();
            f2.setTitulo("Toy Story");
            f2.setCategoria("Animação");
            f2.setAno(1995);
            f2 = fs.cadastrar(f2);
            System.out.println("Filme cadastrado: " + f2);

            // Listar filmes
            System.out.println("\\nLista de filmes:");
            fs.listar().forEach(System.out::println);

            // Registrar empréstimo
            es.registrarEmprestimo(c.getId(), f1.getId(), LocalDate.now());
            System.out.println("Empréstimo registrado para cliente id=" + c.getId() + ", filme id=" + f1.getId());

            // Excluir filme (teste)
            boolean excluiu = fs.excluir(f2.getId());
            System.out.println("Exclusão do filme id=" + f2.getId() + ": " + excluiu);

            System.out.println("=== FIM DOS TESTES ===");
        } catch (Exception ex) {
            System.err.println("Erro durante os testes: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
