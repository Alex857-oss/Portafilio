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

	/**
	*Funcion que realiza cuenta regresiva de acuerdo a un 
	*/

	public static void cuentaRegresiva(int n){
		if(n < 1){
			return;
		}else{
			System.out.println(n + " ");
			cuentaRegresiva(n-1);
		}
	}
	
	public static void main(String[] args){
		//saludo(100, "Alejandro");
		cuentaRegresiva(100);
	}

}