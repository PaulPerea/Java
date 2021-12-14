package entidad;

public class Cliente {
	private String dni;
	private String apellidos;
	private String nombres;
	private String direccion;
	private String tele_movil;
	private String cod_dist;
	
	
	
	public Cliente() {
	}



	public Cliente(String dni, String apellidos, String nombres, String direccion, String tele_movil, String cod_dist) {
		this.dni = dni;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.direccion = direccion;
		this.tele_movil = tele_movil;
		this.cod_dist = cod_dist;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTele_movil() {
		return tele_movil;
	}



	public void setTele_movil(String tele_movil) {
		this.tele_movil = tele_movil;
	}



	public String getCod_dist() {
		return cod_dist;
	}



	public void setCod_dist(String cod_dist) {
		this.cod_dist = cod_dist;
	}
	
	
	
	
	
	
}
