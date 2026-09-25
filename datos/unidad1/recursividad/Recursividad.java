package datos.unidad1.recursividad;
public class Recursividad {
	
	public static void saludo(int total, String nombre) {
	
	if(total <= 0)
		return;
	else{
		System.out.println("Hola " + nombre);
		saludo(total-1, nombre);
	}
	
	}
	
	public static void main(String[] args){
		saludo(100, "Alejandro");
	}

}