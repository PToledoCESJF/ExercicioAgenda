package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
@WebServlet(name="EditaRegistroServlet", urlPatterns = {"/edita.html"})
public class EditaRegistroServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Contato contato = new Contato();
        Long id = Long.parseLong(request.getParameter("id"));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Exercicio01Agenda";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM contato WHERE id ="+id);
            
            if(resultado.next()){
                contato.setId(resultado.getLong("id"));
                contato.setNome(resultado.getString("nome"));
                contato.setSobrenome(resultado.getString("sobrenome"));
                contato.setTelefone(resultado.getString("sobrenome"));
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditaRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditaRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("pessoa", contato);
        request.getRequestDispatcher("WEB-INF/edita-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Contato contato = new Contato();
        contato.setId(Long.parseLong(request.getParameter("id")));
        contato.setNome(request.getParameter("nome"));
        contato.setSobrenome(request.getParameter("sobrenome"));
        contato.setTelefone(request.getParameter("telefone"));
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Exercicio01Agenda";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("UPDATE contato SET nome='"
                    +contato.getNome()+"', sobrenome='"
                    +contato.getSobrenome()+"', telefone='"
                    +contato.getTelefone()+"'WHERE id="
                    +contato.getId()
            );
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditaRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditaRegistroServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("lista.html");

    }

}
