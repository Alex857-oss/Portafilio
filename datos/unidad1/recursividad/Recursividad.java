package datos.unidad1.recursividad;
public class Recursividad {

    public static void saludo(int total, String nombre) {
        if (total <= 0)
            return;
        else {
            System.out.println("Hola " + nombre);
            saludo(total - 1, nombre);
        }
    }

    /**
     * Funcion que realiza cuenta regresiva
     */
    public static void cuentaRegresiva(int n) {

        if (n < 1) {
            return;
        } else {
            System.out.println(n);
            cuentaRegresiva(n - 1);
        }
    }

    // Suma recursiva de los elementos del arreglo
    public static int sumaRecursiva(int[] datos, int longitud) {

        if (longitud <= 0) {
            return 0;
        } else {
            return datos[longitud - 1] + sumaRecursiva(datos, longitud - 1);
        }
    }

    public static void main(String[] args) {
        // saludo(100, "Alejandro");
        // cuentaRegresiva(100);
        int[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int resultado = sumaRecursiva(data, data.length);
        System.out.println("La suma es: " + resultado);
    }
}