package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
@WebServlet(name = "NovoRegistroServlet", urlPatterns = {"/novo.html"})
public class NovoRegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/novo-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Contato contato = new Contato();
        contato.setNome(request.getParameter("nome"));
        contato.setSobrenome(request.getParameter("sobrenome"));
        contato.setTelefone(request.getParameter("telefone"));

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Exercicio01Agenda";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            Statement operacao = conexao.createStatement();
            String sql = "INSERT INTO contato(nome, sobrenome, telefone) VALUES('"
                    + contato.getNome() + "', '"
                    + contato.getSobrenome() + "','"
                    + contato.getTelefone() + "')";
            operacao.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(NovoRegistroServlet.class.getName()).log(Level.SEVERE, "Erro ao inserir o registro!{0}", e);
        }
        response.sendRedirect("/lista.html");
    }
}
