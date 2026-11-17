package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {


private Connection conectar() {
    try {
        String host = System.getenv("DB_HOST");
        String port = System.getenv("DB_PORT");
        String database = System.getenv("DB_NAME");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        // Verificar variáveis
        System.out.println("===== CONEXÃO MYSQL =====");
        System.out.println("HOST: " + host);
        System.out.println("PORT: " + port);
        System.out.println("DATABASE: " + database);
        System.out.println("USER: " + user);
        System.out.println("=========================");

        if (host == null || port == null ||
            database == null || user == null ||
            password == null) {
            throw new RuntimeException(
                "Uma ou mais variáveis DB_ não foram configuradas."
            );
        }

        String url = "jdbc:mysql://" + host + ":" + port
                + "/" + database
                + "?useTimezone=true&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
            url, user, password
        );

        System.out.println("MYSQL CONECTADO COM SUCESSO!");

        return con;

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Erro ao conectar ao banco", e);
    }
}

	// CRUD CREATE
	public void inserirMidia(JavaBeans midia) {
		String create = "insert into midia (nome, genero, autor, ano, tipo, sinopse, imagem) values (?,?,?,?,?,?,?)";
		try {
			// Abrir conexão
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, midia.getNome());
			pst.setString(2, midia.getGenero());
			pst.setString(3, midia.getAutor());
			pst.setInt(4, midia.getAno());
			pst.setString(5, midia.getTipo());
			pst.setString(6, midia.getSinopse());
			pst.setString(7, midia.getImagem());

			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com o banco
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CRUD READ

	public ArrayList<JavaBeans> listaMidia() {
		// objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> midia = new ArrayList<>();
		String read = "select * from midia order by id";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado quando houver midias
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String genero = rs.getString(3);
				String autor = rs.getString(4);
				String ano = rs.getString(5);
				String tipo = rs.getString(6);
				String sinopse = rs.getString(7);
				String imagem = rs.getString(8);

				// populando o ArrayList
				midia.add(new JavaBeans(id, nome, genero, autor, Integer.parseInt(ano), tipo, sinopse, imagem));
			}
			con.close();
			return midia;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public JavaBeans listarInformacoes(int idM) {
		// objeto para acessar a classe JavaBeans
		JavaBeans midia = null;
		String read = "select * from midia WHERE id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setInt(1, idM);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado quando houver midias
			if (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String id = rs.getString("id");
				String nome = rs.getString("nome");
				String genero = rs.getString("genero");
				String autor = rs.getString("autor");
				String ano = rs.getString("ano");
				String tipo = rs.getString("tipo");
				String sinopse = rs.getString("sinopse");
				String imagem = rs.getString("imagem");

				// populando o ArrayList
				midia = new JavaBeans(id, nome, genero, autor, Integer.parseInt(ano), tipo, sinopse, imagem);
			}
			con.close();
			return midia;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<JavaBeans> listarImagens() {

		ArrayList<JavaBeans> lista = new ArrayList<>();

		String sql = "SELECT id, nome, imagem FROM midia " + "WHERE imagem IS NOT NULL AND imagem <> ''";

		try (Connection con = conectar();

		) {

			if (con == null) {
				throw new SQLException("Não foi possível conectar ao MySQL.");
			}

			try (PreparedStatement stmt = con.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {

					JavaBeans m = new JavaBeans();

					m.setId(rs.getString("id"));
					m.setNome(rs.getString("nome"));
					m.setImagem(rs.getString("imagem"));

					lista.add(m);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}
}
