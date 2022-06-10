package cocina;



public class Test {

	public static void main(String[] args) {
		
		
		
		Cocina cocina = new Cocina("La esquina de Ana");
		cocina.agregarProducto("Garbanzos", false, 20, 5);
		cocina.agregarProducto("Carne", true, 100, 20);
		cocina.agregarProducto("Tomate", false, 10, 6);
		cocina.agregarProducto("Harina", false, 20, 10);
		cocina.agregarProducto("Harina", false, 80, 50);
		cocina.agregarProducto("Huevos", true, 60, 12);
		cocina.agregarProducto("Leche", true, 100, 10);

		cocina.extraer("Tomate", false, 8);
		cocina.extraer("Tomate", false, 8);
		cocina.extraer("Harina", false, 60);
		cocina.extraer("Leche", true, 50);
		cocina.extraer("Espinaca", false, 4);
		
		cocina.listaDeRequerimientos();
	}

}
