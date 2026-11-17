<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse"%>

<%
JavaBeans midia = (JavaBeans) request.getAttribute("midia");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Set <%=midia.getNome()%></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cabecalho">
			<a href="index"><img src="imagens/logo.png"></a> <a href="main">Início</a>
			<a href="cadastro">Nova Mídia</a> <a href="contatos">Contatos</a>
		</div>
		<div class="informacoes">
			<div class="capa">
				<img src="<%=midia.getImagem()%>">
			</div>

			<div class="tabela">
				<table>
					<tbody>
						<tr>
							<td class="td1">Gênero</td>
							<td><%=midia.getGenero()%></td>
						</tr>

						<tr>
							<td class="td1">Autor</td>
							<td><%=midia.getAutor()%></td>
						</tr>

						<tr>
							<td class="td1">Ano</td>
							<td><%=midia.getAno()%></td>
						</tr>

						<tr>
							<td class="td1">Tipo</td>
							<td><%=midia.getTipo()%></td>
						</tr>

						<tr>
							<td class="td1">Sinopse</td>
							<td><%=midia.getSinopse()%></td>
						</tr>
					</tbody>
				</table>
				<a href="listaMidia?tipo=<%=midia.getTipo()%>">Voltar para <%=midia.getTipo().toLowerCase()%>s
				</a>
			</div>
		</div>
	</div>
</body>
</html>
