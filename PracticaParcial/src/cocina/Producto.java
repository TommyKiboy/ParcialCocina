package cocina;

public class Producto {

	
	private String nombre;
	
	private double cantidad, puntoReposicion;
	
	private boolean necesitaRepo;
	
	
	public Producto(String nombre, double cantidad, double puntoReposicion) {
		
		this.nombre = nombre;
		
		if (cantidad >= 0) {
			
			this.cantidad = cantidad;
			
		} else {
			
			this.cantidad = 0;
		}
		
		this.puntoReposicion = puntoReposicion;
	}
	
	
	
	
	public String getNombre() {
		
		return this.nombre;
	}
	
	
	public double actualizarCantidad(double cantidad) {
		
		double cantidadExtraida = 0;
		
		if (cantidad >= 0) {
			
			if (cantidad <= this.cantidad) {
				
				this.cantidad -= cantidad;
				
				cantidadExtraida = cantidad;
				
				if (this.cantidad < this.puntoReposicion) {
					
					if (this.cantidad == 0) {
						
						System.out.println("El producto "+this.nombre+" se quedo sin stock. Faltante: "+getFaltante());
						
						necesitaRepo = true;
						
					} else {
						
						System.out.println("El producto "+this.nombre+" esta con stock insuficiente. Faltante: "+getFaltante());
						
						necesitaRepo = true;
					}
				}
				
			} else {
			
				cantidadExtraida = this.cantidad; 
				
				this.cantidad = 0;
				
				System.out.println("El producto "+this.nombre+" se quedo sin stock. Faltante: "+getFaltante());
				
				necesitaRepo = true;
						
			}
			
			
		} else {
			
			System.out.println("Error. Cantidad incorrecta. ");
		}
		
		return cantidadExtraida;
	}
	
	
	public double getCantidad() {
		
		return this.cantidad;
	}
	
	
	
	public boolean getNecesitaRepo() {
		
		return this.necesitaRepo;
	}
	
	
	
	public double getFaltante() {
		
		double faltante = (this.puntoReposicion - this.cantidad);
		
		return faltante;
	}
	
	
	
	public void setCantidad(double cantidad) {
		
		this.cantidad += cantidad;
	}
	
	
	
	public void setPuntoReposicion(double puntoReposicion) {
		
		this.puntoReposicion = puntoReposicion;
	}
}
