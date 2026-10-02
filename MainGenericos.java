
/* José Alejandro Olvera Lugo
 * 
 * OBSERVACIONES GENERALES:
 * - Se implementó la clase abstracta genérica Producto<T> con su método
 *   abstracto mostrarDetalles().
 * - Se crearon las subclases Libro (T -> Integer), Electronico (T -> String)
 *   y Ropa (T -> String) como ampliación del sistema.
 * - Se utilizó un ArrayList<Producto<?>> dinámico para manejar el inventario
 *   sin límite de productos.
 * - Se integró la lógica de filtrado inteligente para libros con más de 400
 *   páginas y electrónicos con garantía mayor a 1 año.
 */

import java.util.ArrayList;
import java.util.List;

// 1. Clase abstracta genérica Producto<T>
abstract class Producto<T> {
    private String nombre;
    private double precio;
    private T extra; // Información adicional genérica

    public Producto(String nombre, double precio, T extra) {
        this.nombre = nombre;
        this.precio = precio;
        this.extra = extra;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public T getExtra() {
        return extra;
    }

    // Método abstracto obligatorio para cada subclase
    public abstract void mostrarDetalles();
}

// 2. Subclase Libro (información extra: número de páginas - Integer)
class Libro extends Producto<Integer> {

    public Libro(String nombre, double precio, Integer paginas) {
        super(nombre, precio, paginas);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + getNombre() + " | Precio: $" + getPrecio() + " | Páginas: " + getExtra());
    }
}

// 3. Subclase Electronico (información extra: garantía - String)
class Electronico extends Producto<String> {

    public Electronico(String nombre, double precio, String garantia) {
        super(nombre, precio, garantia);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Electrónico: " + getNombre() + " | Precio: $" + getPrecio() + " | Garantía: " + getExtra());
    }
}

// 4. Subclase Ropa (Ampliación del sistema - información extra: talla - String)
class Ropa extends Producto<String> {

    public Ropa(String nombre, double precio, String talla) {
        super(nombre, precio, talla);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Ropa: " + getNombre() + " | Precio: $" + getPrecio() + " | Talla: " + getExtra());
    }
}

// 5. Clase Principal
public class MainGenericos {
    public static void main(String[] args) {
        // Uso de ArrayList dinámico en lugar de un arreglo fijo
        List<Producto<?>> inventario = new ArrayList<>();

        // Carga de productos
        inventario.add(new Libro("Java Básico", 299.99, 350));
        inventario.add(new Electronico("Laptop ASUS", 15999.99, "2 años"));
        inventario.add(new Libro("Patrones de Diseño", 499.50, 420));
        inventario.add(new Electronico("Smartphone Samsung", 10999.00, "1 año"));
        inventario.add(new Ropa("Chamarra de Mezclilla", 899.00, "L"));

        // Recorrido y visualización del inventario completo
        System.out.println("=== INVENTARIO COMPLETO ===");
        for (Producto<?> p : inventario) {
            p.mostrarDetalles();
        }

        // Filtrado inteligente (Desafío)
        System.out.println("\n=== FILTRADO INTELIGENTE ===");
        System.out.println("• Libros con más de 400 páginas:");
        System.out.println("• Electrónicos con garantía mayor a 1 año:\n");

        for (Producto<?> p : inventario) {
            if (p instanceof Libro) {
                Libro libro = (Libro) p;
                if (libro.getExtra() > 400) { // Filtro: Páginas > 400
                    libro.mostrarDetalles();
                }
            } else if (p instanceof Electronico) {
                Electronico elec = (Electronico) p;
                if (!elec.getExtra().equalsIgnoreCase("1 año")) { // Filtro: Garantía > 1 año
                    elec.mostrarDetalles();
                }
            }
        }
    }
}