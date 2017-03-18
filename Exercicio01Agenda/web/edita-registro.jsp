<%-- 
    Document   : edita-registro
    Created on : 18/03/2017, 18:38:16
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edita Registro</title>
    </head>
    <body>
        <h1>Edita Registro!</h1>
        <form method="POST">
            <div><input type="hidden" name="id" value="${pessoa.id}"/>id:${pessoa.id}</div>
            <div><label>Nome: <input type="text" name="nome" value="${pessoa.nome}"/></label></div>
            <div><label>Sobrenome: <input type="text" name="sobrenome" value="${pessoa.sobrenome}"/></label></div>
            <div><label>Telefone: <input type="text" name="telefone" value="${pessoa.telefone}"/></label></div>
            <div><input type="submit"/></div>
        </form>
    </body>
</html>
