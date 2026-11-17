package contoller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/listaMidia", "/cadastro", "/novaMidia", "/cadastrar",
		"/informacoes", "/index" })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans midia = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			catalogo(request, response);
		} else if (action.equals("/listaMidia")) {
			listaMidia(request, response);
		} else if (action.equals("/cadastro")) {
			cadastro(request, response);
		} else if (action.equals("/informacoes")) {
			informacoes(request, response);
		} else if (action.equals("/index")) {
			index(request, response);
		} else {
			response.sendRedirect("/main");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/cadastrar")) {
			novaMidia(request, response);
		}
	}

	protected void catalogo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
		rd.forward(request, response);
	}

	// Listar midias
	protected void listaMidia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		// objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listaMidia();

		// encaminhar a lista ao documento listaMidia.jps
		request.setAttribute("midia", lista);
		request.setAttribute("tipoSelecionado", tipo);

		RequestDispatcher rd = request.getRequestDispatcher("listaMidia.jsp");
		rd.forward(request, response);
	}

	protected void cadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("novaMidia.html");
		rd.forward(request, response);
	}

	// Nova midia
	protected void novaMidia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis JavaBeans
		midia.setNome(request.getParameter("nome"));
		midia.setGenero(request.getParameter("genero"));
		midia.setAutor(request.getParameter("autor"));
		midia.setAno(Integer.parseInt(request.getParameter("ano")));
		String tipo = request.getParameter("tipo");
		midia.setTipo(tipo);
		midia.setSinopse(request.getParameter("sinopse"));

		String imagem = request.getParameter("imagem");
		midia.setImagem(imagem);

		// Invocar o método inserirMidia passando o objeto midia
		dao.inserirMidia(midia);
		// Redirecionar para o documento novaMidia.jsp
		response.sendRedirect("main");
	}

	private void informacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idM = Integer.parseInt(request.getParameter("id"));

		JavaBeans midia = dao.listarInformacoes(idM);
		request.setAttribute("midia", midia);

		RequestDispatcher rd = request.getRequestDispatcher("informacoes.jsp");

		rd.forward(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<JavaBeans> lista = dao.listarImagens();

		request.setAttribute("imagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

		rd.forward(request, response);
	}
}
