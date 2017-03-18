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
@WebServlet(name="ExcluiRegistroServlet", urlPatterns = {"/exclui.html"})
public class ExcluiRegistroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Long id = Long.parseLong(request.getParameter("id"));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Exercicio01Agenda";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("DELETE FROM contato WHERE id=" +id);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExcluiRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
