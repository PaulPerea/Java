package entidad;

public class Categoria {
	private String codCate;
	private String nombreCate;
	
	public Categoria(String codCate, String nombreCate) {
		this.codCate = codCate;
		this.nombreCate = nombreCate;
	}

	
	public Categoria() {
		super();
	}


	public String getCodCate() {
		return codCate;
	}

	public void setCodCate(String codCate) {
		this.codCate = codCate;
	}

	public String getNombreCate() {
		return nombreCate;
	}

	public void setNombreCate(String nombreCate) {
		this.nombreCate = nombreCate;
	}
	
	
}
