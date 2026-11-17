<%@ page import="java.util.ArrayList"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="jakarta.servlet.http.HttpServletResponse"%>

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
		<div class="carrossel">
			<div class="carrossel-track">
				<%
				@SuppressWarnings("unchecked")
				ArrayList<JavaBeans> imagem = (ArrayList<JavaBeans>) request.getAttribute("imagem");

				if (imagem != null) {
					for (JavaBeans m : imagem) {
				%>
				<a href="informacoes?id=<%=m.getId()%>"><img
					src="<%=m.getImagem()%>" alt="<%=m.getNome()%>"></a>
				<%
				}
				}
				%>
			</div>
		</div>
		<div class="frente">
			<img src="imagens/logo.png" class="imagem"> <a href="main"
				class="botao">Acessar</a>
		</div>
	</div>
	
	<script>
		let mouseX = -1;
		let mouseY = -1;
		
		document.addEventListener("mousemove", function(e) {
		    mouseX = e.clientX;
		    mouseY = e.clientY;
		});
		
		function atualizarHover() {
		
		    // Identifica o elemento que está embaixo do mouse
		    const elemento = document.elementFromPoint(mouseX, mouseY);
		
		    // Remove o efeito de todos os links
		    document.querySelectorAll(".carrossel-track a")
		        .forEach(link => {
		            link.classList.remove("hover-ativo");
		        });
		
		    // Ativa o efeito no link atual
		    if (elemento) {
		        const link = elemento.closest(".carrossel-track a");
		
		        if (link) {
		            link.classList.add("hover-ativo");
		        }
		    }
		
		    requestAnimationFrame(atualizarHover);
		}
		
		atualizarHover();
	</script>
</body>
</html>