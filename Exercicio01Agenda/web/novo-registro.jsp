<%-- 
    Document   : novo-registro
    Created on : 18/03/2017, 16:33:56
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Registro</title>
    </head>
    <body>
        <h1>Novo Registro!</h1>
        <form method="POST">
            <div><label>Nome: <input type="text" name="nome"/></label></div>
            <div><label>Sobrenome: <input type="text" name="sobrenome"/></label></div>
            <div><label>Telefone: <input type="text" name="telefone"/></label></div>
            <div><input type="submit"/></div>        
        </form>
    </body>
</html>
