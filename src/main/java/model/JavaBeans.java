package model;

public class JavaBeans {
	private String id;
	private String nome;
	private String genero;
	private String autor;
	private int ano;
	private String tipo;
	private String sinopse;
	private String imagem;

	public JavaBeans() {
		super();
	}
	
	public JavaBeans(String id, String nome, String genero, String autor, int ano, String tipo,
			String sinopse, String imagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.autor = autor;
		this.ano = ano;
		this.tipo = tipo;
		this.sinopse = sinopse;
		this.imagem = imagem;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
