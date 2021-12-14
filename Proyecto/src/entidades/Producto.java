package entidades;

public class Producto {

	private String des;
	private String cant;
	private String prov;
	private String id;
	public Producto() {
		
	}
	public Producto(String des, String cant, String prov, String id) {
		this.des = des;
		this.cant = cant;
		this.prov = prov;
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getCant() {
		return cant;
	}
	public void setCant(String cant) {
		this.cant = cant;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
