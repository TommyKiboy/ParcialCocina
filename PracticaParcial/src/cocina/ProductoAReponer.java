package cocina;

public class ProductoAReponer {

	
	private String nombre;
	
	private double cantidadAComprar;
	
	
	
	public ProductoAReponer(String nombre, double cantidadAComprar) {
		
		this.nombre = nombre;
		
		this.cantidadAComprar = cantidadAComprar;
	}
	
	
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	
	
	public double getReposicion() {
		
		return cantidadAComprar;
	}
	
	
	public void setCantidadAComprar(double cantidad) {
		
		this.cantidadAComprar = (cantidad * 1.20);
	}
}
