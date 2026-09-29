Introducción

Mi matrícula termina en 2 y el valor de K es 2 + 1 = 3. Con ese valor hice todo el
ejercicio. En cada fase pongo el código ya corregido con las explicaciones teóricas,
luego lo que hice y por último lo que imprime en consola.

Fase 1: Arreglo unidimensional

Código corregido
int K = 3; // matrícula 1225100262 -> último dígito 2 -> K = 2 + 1 = 3
int[] lecturas = {10, -5, 20, K * 2, -1, 30, 0, 15};
// Tarea 1.1: se empieza en length - 1 y se llega hasta 0.
// Tarea 1.2: los arreglos en Java se indexan desde 0, así que el
// último índice válido es length - 1. El código original empezaba en
// i = lecturas.length (8), pero el índice 8 no existe (solo hay del
// 0 al 7), por eso lanzaba ArrayIndexOutOfBoundsException en la
// primera vuelta. .length indica la cantidad de elementos, no la
// posición del último.
 if (lecturas[i] > 0) {
 System.out.println("Lectura positiva: " + lecturas[i]);
 }
}
for (int i = lecturas.length - 1; i >= 0; i--) {
Qué corregí
El bucle empezaba en lecturas.length, que vale 8. Como el arreglo va del índice 0 al 7,
el 8 no existe y Java lanzaba ArrayIndexOutOfBoundsException desde la primera
vuelta. Lo arreglé empezando en lecturas.length - 1, que es el último índice válido, y
bajando hasta 0.
Salida en consola (K = 3)
Lectura positiva: 15
Lectura positiva: 30
Lectura positiva: 6
Lectura positiva: 20
Lectura positiva: 10

Fase 2: Arreglo bidimensional irregular

Código corregido
int[][] ventas = new int[3][];
ventas[0] = new int[K]; // Vendedor 1
ventas[1] = new int[K + 1]; // Vendedor 2
ventas[2] = new int[2]; // Vendedor 3
// Tarea 2.1: cada fila se recorre con su propio largo (ventas[i].length),
// porque el original usaba 4 columnas fijas y fallaba en las filas
// más cortas.
for (int i = 0; i < ventas.length; i++) {
 for (int j = 0; j < ventas[i].length; j++) {
 ventas[i][j] = (i + 1) * (j + 1);
 }
}

// Tarea 2.2: suma total de todos los elementos
int suma = 0;
for (int i = 0; i < ventas.length; i++) {
 for (int j = 0; j < ventas[i].length; j++) {
 suma += ventas[i][j];
 }
}
System.out.println("Suma total de la matriz irregular: " + suma);

// Tarea 2.3: un Jagged Array reserva memoria solo para los elementos
// que cada fila necesita. Una matriz N x M reserva N*M espacios aunque
// muchas filas ocupen menos, y eso desperdicia memoria. Aquí se usan
// 9 espacios; una matriz rectangular de 3x4 usaría 12.

Qué corregí
El código original recorría 4 columnas en todas las filas, pero mis filas miden 3, 4 y 2. Al
llegar a la columna 3 de la primera fila o a la columna 2 de la tercera, Java lanzaba una
excepción. Ahora el bucle interno usa ventas[i].length, que es el tamaño real de cada
fila. Después agregué otro recorrido para sumar todos los elementos.
Las filas quedan así: [1, 2, 3], [2, 4, 6, 8] y [3, 6]. Sumadas dan 6 + 20 + 9 = 35.
Pregunta 2.3: ventaja de memoria del Jagged Array

La ventaja es que cada fila solo guarda los espacios que necesita. En una matriz
tradicional de N x M todas las filas tienen el mismo tamaño, así que si una fila necesita
menos columnas, el resto se queda vacío y se desperdicia memoria. En mi caso el
Jagged Array usa 3 + 4 + 2 = 9 espacios, mientras que una matriz rectangular de 3 x 4
usaría 12.
Salida en consola (K = 3)
Suma total de la matriz irregular: 35
Fase 3: Arreglo tridimensional
Código corregido
int[][][] cubo = new int[2][K][K];
for (int i = 0; i < 2; i++)
 for (int j = 0; j < K; j++)
 for (int k = 0; k < K; k++)
 cubo[i][j][k] = i + j + k + 1;
// Tarea 3.1: el while nunca terminaba porque i nunca cambiaba y la
// condición (i < 2) siempre era verdadera. Faltaba i++ al final de
// cada vuelta.
// Tarea 3.2: versión con for-each. Como el for-each no da índices,
// se llevan contadores manuales solo para poder imprimir la posición.
int total = 0;
int i = 0;
for (int[][] plano : cubo) {
 int j = 0;
 for (int[] fila : plano) {
 int k = 0;
 for (int valor : fila) {
 if (valor % 3 == 0) {
 System.out.println("Múltiplo encontrado en: " + i + "," + j +
"," + k);
 total++;
 }
 k++;
 }
 j++;
 }
 i++;
}
System.out.println("Total de múltiplos de 3: " + total);
// Tarea 3.3: en el for-each la variable (valor) es una copia del
// elemento, no una referencia a la posición del arreglo. Si se le
// asigna algo, solo cambia la copia y el arreglo queda igual. Además
// no se conoce el índice. Para modificar valores hay que usar for con
// índices: cubo[i][j][k] = ...
Qué corregí

Tarea 3.1: el while se congelaba porque la variable i valía siempre 0 y la condición i < 2
nunca dejaba de cumplirse. Faltaba el i++ al final de cada vuelta.

Tarea 3.2: cambié todo el recorrido a for-each. Como este tipo de bucle no da los
índices, dejé tres contadores (i, j y k) que aumento a mano, solo para poder imprimir la posición donde está cada múltiplo de 3. También agregué un contador para saber
cuántos hay en total.

Con K = 3 el cubo es de 2 x 3 x 3 y cada valor se calcula como i + j + k + 1. Salen 6
múltiplos de 3.

Pregunta 3.3: limitación del for-each al modificar valores
En el for-each la variable del bucle es una copia del elemento. Si escribo valor = 10,
solo cambio la copia y el arreglo sigue igual. Además no tengo el índice, así que no
puedo decir en qué posición asignar. Por eso, si la tarea fuera modificar valores dentro
del arreglo, tengo que usar el for tradicional con índices, por ejemplo cubo[i][j][k] = 10.
Salida en consola (K = 3)
Múltiplo encontrado en: 0,0,2
Múltiplo encontrado en: 0,1,1
Múltiplo encontrado en: 0,2,0
Múltiplo encontrado en: 1,0,1
Múltiplo encontrado en: 1,1,0
Múltiplo encontrado en: 1,2,2
Total de múltiplos de 3: 6                                                                                                                                         esto es una actividad, has que cada parrafo o palabra tenga un "//" al inicio para que cuando lo meta a code se ejecuten bien los codigos 