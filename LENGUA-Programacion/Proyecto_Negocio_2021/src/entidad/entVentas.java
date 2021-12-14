package entidad;

public class entVentas {

	private String tienda;
	private double monto;
	private String fechaventa;
	
public entVentas(String tienda, double monto, String fechaventa) {
	this.tienda = tienda;
	this.monto = monto;
	this.fechaventa = fechaventa;
}

public String getTienda() {
	return tienda;
}

public void setTienda(String tienda) {
	this.tienda = tienda;
}

public double getMonto() {
	return monto;
}

public void setMonto(double monto) {
	this.monto = monto;
}

public String getFechaventa() {
	return fechaventa;
}

public void setFechaventa(String fechaventa) {
	this.fechaventa = fechaventa;
}
	
	
	
}
