<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("midia");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" name="viewport"
	content="width=device-width, initial-scale=1.0">
<title>Set Mídias</title>
<link rel="icon" href="imagens/logo.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<div class="cabecalho">
			<a href="index"><img src="imagens/logo.png"></a> <a href="main"
				class="active">Início</a> <a href="cadastro">Nova Mídia</a> <a
				href="contatos">Contatos</a>
		</div>

		<div class="conteudo">
			<a href="listaMidia?tipo=Livro" class="botao-efeito"> <img
				src="imagens/livros.png" class="imagem">
			</a> <a href="listaMidia?tipo=Filme" class="botao-efeito"> <img
				src="imagens/filmes.png" class="imagem">
			</a> <a href="listaMidia?tipo=Serie" class="botao-efeito"> <img
				src="imagens/series.png" class="imagem">
			</a>
		</div>
	</div>

	<script>
		window.addEventListener("load", () => {
		
		    const botoes = document.querySelectorAll(".botao-efeito");
		
		    botoes.forEach((botao, i) => {
		
		        setTimeout(() => {
		
		            botao.classList.add("ativo");
		
		            setTimeout(() => {
		                botao.classList.remove("ativo");
		            }, 700);
		
		        }, i * 600);
		
		    });
		
		});
	</script>
</body>
</html>