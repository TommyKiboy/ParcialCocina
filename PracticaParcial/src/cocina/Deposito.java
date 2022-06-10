package cocina;

import java.util.ArrayList;

public class Deposito {

	
	private ArrayList<Producto> productos;
	
	private ArrayList<ProductoAReponer> listaRequerimientos;
	
	private TipoDeposito tipoDeposito;
	
	
	
	
	public Deposito(TipoDeposito tipo) {
		
		this.tipoDeposito = tipo;
		
		this.productos = new ArrayList<Producto>();
		
		this.listaRequerimientos = new ArrayList<ProductoAReponer>();
	}
	
	
	
	
	public Producto agregarProducto
	                (String nombre, double cantidad,
			         double puntoReposicion) {
		
		Producto productoEncontrado = null;
		
		for (int indice = 0; indice < productos.size(); indice++) {
			
			Producto producto = this.productos.get(indice);
			
			if (producto.getNombre() == nombre) {
				
				productoEncontrado = producto;
				
			} else {
				
				productoEncontrado = null;
			}
			
		}
		
		if (productoEncontrado == null) {
			
			Producto productoNuevo = new Producto(nombre, cantidad, puntoReposicion);
			
			this.productos.add(productoNuevo);
			
			productoEncontrado = productoNuevo;
			
		} else {
			
			productoEncontrado.setCantidad(cantidad);
			
			productoEncontrado.setPuntoReposicion(puntoReposicion);
			
		}
		
		return productoEncontrado;
	}
	
	
	
	
	public double extraer(double cantidad, String nombreProducto) {
		
		double extraido = 0;
		
		Producto productoEncontrado = null;
		
		for (int indice = 0; indice < productos.size(); indice++) {
			
			Producto productoAExtraer = productos.get(indice);
			
			if (productoAExtraer.getNombre() == nombreProducto) {
				
				productoEncontrado = productoAExtraer;
				
			}
			
		}
		
		if (productoEncontrado == null) {
			
			System.out.println("El producto "+nombreProducto+" no esta en el deposito. ");
			
			System.out.println("Se pidió "+cantidad+" de "+nombreProducto+". Se obtuvo: 0");
			
			ProductoAReponer productoAReponer = new ProductoAReponer(nombreProducto, (cantidad * 1.20) );
			
			listaRequerimientos.add(productoAReponer);
			
		} else {
			
			extraido = productoEncontrado.actualizarCantidad(cantidad);
			
			System.out.println("Se pidió "+cantidad+" de "+nombreProducto+". Se obtuvo: "+extraido);
		
		}
		
		if (productoEncontrado != null) {
		
			
			if (productoEncontrado.getCantidad() == 0) {
				
				productos.remove(productoEncontrado);
				
			} else if (productoEncontrado.getNecesitaRepo()) {
				
				ProductoAReponer productoExiste = null;
				
				ProductoAReponer producto = null;
				
				ProductoAReponer productoAReponer = new ProductoAReponer(productoEncontrado.getNombre(), (productoEncontrado.getFaltante() * 1.20));
			
				for (int indice = 0; indice < listaRequerimientos.size(); indice++) {
					
					producto = listaRequerimientos.get(indice);
					
					if (producto.getNombre().equals(productoAReponer.getNombre())) {
						
						productoExiste = producto;
						
					}
					
				}
				
				if (productoExiste != null) {
					
					productoExiste.setCantidadAComprar(cantidad);
					
				} else {
					
					listaRequerimientos.add(productoAReponer);
				}
					
			}
			
			
			
		}
		
		return extraido;
	}
	
	
	
	
	public ArrayList<ProductoAReponer> listaDeRequerimientos() {
		
		return this.listaRequerimientos;
	}
	
	
	
	
	
	
	
	
}
