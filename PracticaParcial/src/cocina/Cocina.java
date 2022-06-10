package cocina;

import java.util.ArrayList;

public class Cocina {

	
	private String nombre;
	
	private Deposito refrigerados;
	
	private Deposito noRefrigerados;
	
	
	
	public Cocina(String nombre) {
		
		this.nombre = nombre;
		
		this.refrigerados = new Deposito(TipoDeposito.REFRIGERADOS);
		
		this.noRefrigerados = new Deposito(TipoDeposito.NO_REFRIGERADOS);
	}
	
	
	
	public String agregarProducto
	                (String nombre, boolean esRefrigerado, 
			         double cantidad, double puntoReposicion) {
		
		Producto productoAgregado = null;
		
		if (esRefrigerado) {
			
			productoAgregado = this.refrigerados.agregarProducto( nombre, cantidad, puntoReposicion);
			
		} else {
			
			productoAgregado = this.noRefrigerados.agregarProducto(nombre, cantidad, puntoReposicion);
		}
		
		return productoAgregado.getNombre();
	}
	
	
	
	
	public double extraer
	              (String nombre, boolean esRefrigerado, double cantidad) {
		
		double extraido = 0;
		
		if (esRefrigerado) {
			
			extraido = this.refrigerados.extraer(cantidad, nombre);
			
		} else {
			
			extraido = this.noRefrigerados.extraer(cantidad, nombre);
			
		}
		
		return extraido;
	}
	
	
	
	
	public void listaDeRequerimientos() {
		
		ArrayList<ProductoAReponer> listaRepoRefri = refrigerados.listaDeRequerimientos();
		
		for (int indice = 0; indice < listaRepoRefri.size(); indice++) {
			
			ProductoAReponer productoRepo = listaRepoRefri.get(indice);
			
			System.out.println("Requerimiento / Nombre: "+productoRepo.getNombre()+
					           " / Cantidad: "+productoRepo.getReposicion());
		}
		
		ArrayList<ProductoAReponer> listaRepoNoRefri = noRefrigerados.listaDeRequerimientos();
		
		for (int indice = 0; indice < listaRepoNoRefri.size(); indice++) {
			
			ProductoAReponer productoRepo = listaRepoNoRefri.get(indice);
			
			System.out.println("Requerimiento / Nombre: "+productoRepo.getNombre()+
					           " / Cantidad: "+productoRepo.getReposicion());
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
