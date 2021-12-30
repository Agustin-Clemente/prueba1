package models;

public class Libro {
	private String titulo; //en el get y set poner tal cual el nombre del atributo... gettitulo y settitulo
	private String autor;
	private String editorial;
	private String genero;
	private int paginas;

	public Libro(String libro, String autor, String editorial, String genero, int paginas) {
		this.titulo = libro;
		this.autor = autor;
		this.editorial = editorial;
		this.genero = genero;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
