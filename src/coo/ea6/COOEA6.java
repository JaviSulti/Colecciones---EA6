
package coo.ea6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class COOEA6 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        HashMap<String, Double> listadoDePreciosInicial = new HashMap();

        System.out.println("Bienvenida/o a su Lista de Precios. En ella, Ud. podrá cargar sus productos y respectivos precios.");
        System.out.println("------------------------------------------------------------------------------------------");

        HashMap<String, Double> listadoDePrecios = primerProducto(listadoDePreciosInicial);

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("A continuacion, indique el numero de la opcion que desea realizar.");
        int i = 2;
        String otraAccion = "SI";
        do {
            switch (menu()) {
                case 1:
                    introducirNuevoProducto(listadoDePrecios, i);
                    i++;
                    System.out.print("Si desea volver al menu anterior, indique SI. De lo contrario indique NO > ");
                    otraAccion = teclado.next();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Producto del que desea modificar su precio > ");
                    String productoAModificar = teclado.next();
                    listadoDePrecios = modificarPrecio(productoAModificar, listadoDePrecios);
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.print("Si desea volver al menu anterior, indique SI. De lo contrario indique NO > ");
                    otraAccion = teclado.next();
                    break;
                case 3:
                    listadoDePrecios = eliminarProducto(listadoDePrecios);
                    System.out.println("------------------------------------------------------------------------------------------");
                    System.out.print("Si desea volver al menu anterior, indique SI. De lo contrario indique NO > ");
                    otraAccion = teclado.next();
                    break;
                case 4:
                    mostrarListado(listadoDePrecios);
                    System.out.print("Si desea volver al menu anterior, indique SI. De lo contrario indique NO > ");
                    otraAccion = teclado.next();
                    System.out.println("------------------------------------------------------------------------------------------");
                    break;
                case 5:
                    System.out.println("Ud. ha decidido salir.");
                    break;
                default:
                    System.out.println("Ud. ha ingresado una opcion incorrecta. Por favor, escoja entre las opciones 1 y 5.");
            }
        } while (otraAccion.equalsIgnoreCase("si"));

        for (Map.Entry<String, Double> aux : listadoDePrecios.entrySet()) {
            System.out.println(aux.getKey() + " " + aux.getValue());
        }
    }

    public static HashMap primerProducto(HashMap listadoDePreciosInicial) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Por favor, ingrese el nombre del primer producto > ");
        String producto = teclado.next();
        System.out.print("Por favor, ingrese el precio del primer producto > ");
        Double precio = teclado.nextDouble();
        listadoDePreciosInicial.put(producto, precio);
        return listadoDePreciosInicial;
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.print("1. Agregar un nuevo producto.\n2. Modificar el precio de un producto.\n3. Eliminar un producto.\n4. Mostrar todos los productos con sus precios.\n5. Salir.\nOpcion > ");
        int opcion = teclado.nextInt();
        return opcion;
    }

    public static HashMap introducirNuevoProducto(HashMap listadoDePrecios, int i) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Por favor, ingrese el nombre del producto numero " + i + " > ");
        String producto = teclado.next();
        System.out.print("Por favor, ingrese el precio del producto numero " + i + " > ");
        Double precio = teclado.nextDouble();
        listadoDePrecios.put(producto, precio);
        return listadoDePrecios;
    }

    public static HashMap modificarPrecio(String productoAModificar, HashMap listadoDePrecios) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        for (Object aux : listadoDePrecios.keySet()) {
            if (aux.equals(productoAModificar)) {
                System.out.print("Ingrese el nuevo valor del producto > ");
                listadoDePrecios.put(aux, teclado.nextDouble());
                System.out.println("El precio ha sido modificado exitosamente.");
            }
        }
        return listadoDePrecios;
    }

    public static HashMap eliminarProducto(HashMap listadoDePrecios) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese el nombre del Producto que desea eliminar de la lista > ");
        String productoAEliminar = teclado.next();
        listadoDePrecios.remove(productoAEliminar);
        return listadoDePrecios;
    }

    private static void mostrarListado(HashMap<String, Double> listadoDePrecios) {
        System.out.println("El listado actual de Productos y precios es: ");
        listadoDePrecios.entrySet().forEach((entry) -> {
            System.out.println("Producto = " + entry.getKey() + ", Precio = " + entry.getValue());
        });
    }

}
