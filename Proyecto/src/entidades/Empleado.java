package entidades;

public class Empleado {
	private String nom;
	private String ape;
	private String dni;
	private String cargo;
	
	private String edad;
	private String id;
	
	
	public Empleado() {
		
	}


	public Empleado(String nom, String ape, String dni, String cargo, String edad, String id) {
		this.nom = nom;
		this.ape = ape;
		this.dni = dni;
		this.cargo = cargo;
		this.edad = edad;
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getApe() {
		return ape;
	}


	public void setApe(String ape) {
		this.ape = ape;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
