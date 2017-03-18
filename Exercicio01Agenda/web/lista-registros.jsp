<%-- 
    Document   : lista-registros
    Created on : 18/03/2017, 13:22:00
    Author     : Paulo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Registros</title>
    </head>
    <body>
        <h1>Listagem de Registros!</h1>
        <a href="novo-registro.jsp">Novo...</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Telefone</th>
                </tr>
            </thead>
            <c:forEach var="pessoa" items="${pessoas}">
                <tbody>
                    <tr>
                        <td><a href="edita-registro.jsp?id=${pessoa.id}">${pessoa.id}</a></td>
                        <td>${pessoa.nome}</td>
                        <td>${pessoa.sobrenome}</td>
                        <td>${pessoa.telefone}</td>
                        <td><a href="excluir.html?id=${pessoa.id}"><h3>X</h3></a></td>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </body>
</html>
