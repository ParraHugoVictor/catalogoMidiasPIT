
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("midia");

String tipoSelecionado = (String) request.getAttribute("tipoSelecionado");

String titulo = "";

if ("Livro".equals(tipoSelecionado)) {
	titulo = "Livros";
} else if ("Filme".equals(tipoSelecionado)) {
	titulo = "Filmes";
} else if ("Serie".equals(tipoSelecionado)) {
	titulo = "Series";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<link rel="icon" href="imagens/logo.png">
<title><%=titulo%></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cabecalho">
			<a href="index"><img src="imagens/logo.png"></a> <a href="main">Início</a>
			<a href="cadastro">Nova Mídia</a> <a href="contatos">Contatos</a>
		</div>

		<h1><%=titulo%></h1>

		<div class="lista">
			<%
			if (lista != null) {
				for (int i = 0; i < lista.size(); i++) {
					if (tipoSelecionado.equals(lista.get(i).getTipo())) {
			%>

			<a href="informacoes?id=<%=lista.get(i).getId()%>"><img src="<%=lista.get(i).getImagem()%>"></a>

			<%
			}
			}
			}
			%>
		</div>
		<a href="cadastro" class="botao">Adicionar <%=tipoSelecionado.toLowerCase()%></a>
	</div>

	<script>
		const lista = document.querySelector(".lista");

		let velocidade = 1;

		function rolarAutomaticamente() {

			lista.scrollLeft += velocidade;

			if (lista.scrollLeft >= lista.scrollWidth - lista.clientWidth) {
				lista.scrollLeft = 0;
			}

			requestAnimationFrame(rolarAutomaticamente);
		}

		rolarAutomaticamente();
	</script>
</body>
</html>

<%--
<div class="lista">
	<table>
		<tbody>
			<%
			if (lista != null) {
				for (int i = 0; i < lista.size(); i++) {
					if (tipoSelecionado.equals(lista.get(i).getTipo())) {
			%>

			<tr>
				<td class="td1"><img src="imagens/filmes.png"></td>
				<td class="td2"><a
					href="informacoes?id=<%=lista.get(i).getId()%>"> <%=lista.get(i).getNome()%>
				</a></td>
			</tr>

			<%
			}
			}
			}
			%>
		</tbody>
	</table>
</div>
--%>


