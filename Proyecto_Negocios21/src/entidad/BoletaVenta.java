package entidad;

public class BoletaVenta {

	
//Atributos de boleta de venta
private String	nroboleta;
private String fecha_venta;
private String 	tipo_pago;
private String dni_clie;
private String estado;
private double total;
	


//Atributos de Detalle Boleta
private String	cod_prod;
private int cantidad;
private double 	importe;



public BoletaVenta() {
}



public BoletaVenta(String nroboleta, String fecha_venta, String tipo_pago, String dni_clie, String estado,
		double total) {
	this.nroboleta = nroboleta;
	this.fecha_venta = fecha_venta;
	this.tipo_pago = tipo_pago;
	this.dni_clie = dni_clie;
	this.estado = estado;
	this.total = total;
}



public BoletaVenta(String nroboleta, String cod_prod, int cantidad, double importe) {
	this.nroboleta = nroboleta;
	this.cod_prod = cod_prod;
	this.cantidad = cantidad;
	this.importe = importe;
}



public String getNroboleta() {
	return nroboleta;
}



public void setNroboleta(String nroboleta) {
	this.nroboleta = nroboleta;
}



public String getFecha_venta() {
	return fecha_venta;
}



public void setFecha_venta(String fecha_venta) {
	this.fecha_venta = fecha_venta;
}



public String getTipo_pago() {
	return tipo_pago;
}



public void setTipo_pago(String tipo_pago) {
	this.tipo_pago = tipo_pago;
}



public String getDni_clie() {
	return dni_clie;
}



public void setDni_clie(String dni_clie) {
	this.dni_clie = dni_clie;
}



public String getEstado() {
	return estado;
}



public void setEstado(String estado) {
	this.estado = estado;
}



public double getTotal() {
	return total;
}



public void setTotal(double total) {
	this.total = total;
}



public String getCod_prod() {
	return cod_prod;
}



public void setCod_prod(String cod_prod) {
	this.cod_prod = cod_prod;
}



public int getCantidad() {
	return cantidad;
}



public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}



public double getImporte() {
	return importe;
}



public void setImporte(double importe) {
	this.importe = importe;
}
	








	
	
}
