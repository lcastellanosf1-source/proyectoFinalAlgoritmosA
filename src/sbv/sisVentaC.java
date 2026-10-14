/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sbv;
import java.util.Scanner;
/**
 *
 * @author usuario1
 */
public class sisVentaC {
    public static void sisVentaBasico(){
        //funcion para leer datos y la entrada del usuario a la consola.
        Scanner sc = new Scanner (System.in);
    
    // Nota: Para evitar errores de logica se opto por usar operaciones dentro de variables
    
    /** Nota: 
     * En algunos casos donde se deben de imprimir tanto valores como textos en pantalla 
     * se optó por eliminar elementos decorativos ( || ) para evitar que se descentralicen con 
     * los demas caracteres cuando se necesite colocar cantidades numericas o nombres de productos 
     * que excedan los tamaños de margenes. Priorizando las correcciones de errores a temas de logica 
     * en lugar de margenes desalineados.
     */
    
    //contadores y acumuladores generales 
    int totalV = 0;
    int totalP = 0;
    double dineroTv = 0.0;

    // Variables para metodos de pago
    double vEfectivoT = 0.0;
    double vTarjetaT = 0.0;
    double vTransferenciaT = 0.0;

    // Variables para calcular el valor de las ventas
    double ventaMin = 0.0;
    double ventaMax = 0.0;
    boolean primeraV = true;

    // Variable para switch de menu
    int opMenu = 0;

    // Bucle principal del menu
    do {
        System.out.println("         <SISTEMA DE VENTAS>      \n");
        System.out.println("|====================================|");
        System.out.println("|          MENU PRINCIPAL            |");
        System.out.println("|====================================|");
        System.out.println("|                                    |");
        System.out.println("|  Por favor seleccione una opcion   |");
        System.out.println("| Opcion 1: Registrar una venta      |");
        System.out.println("| Opcion 2: Consultar caja           |");
        System.out.println("| Opcion 3: Mostrar estadisticas     |");
        System.out.println("| Opcion 4: Salir                    |");
        System.out.println("|====================================|");
        System.out.print("Escriba aqui su opcion:");
        
        // Nota: la funcion "sc.hasnext" comprueba si un numero NO es entero
        while (!sc.hasNextInt()) {
            System.out.print("""
                             |====================================|
                             | Opcion invalida !!!                |           
                             | Por favor ingrese un numero        |
                             | del 1 al 4.                        |
                             |====================================|
                             """);
            System.out.print("Escriba aqui su opcion:");
            sc.next();
        } // Nota: los booleanos se almacenas en condiciones do. (tener precaucion).

        opMenu = sc.nextInt();

        // Switch para el menu
        // Se uso el rule switch visto en clases 
        switch (opMenu) {

            case 1:
                System.out.println("|====================================|");
                System.out.println("|       REGISTRAR UNA VENTA          |");
                System.out.println("|====================================|\n");
                System.out.println("Cuantos productos tendra en la compra?: ");
                int cantP = sc.nextInt();

                // Validar cantidad de productos
                while (cantP <= 0) {
                    System.out.println("|====================================|");
                    System.out.println("|Error. La cantidad debe ser mayor a 0. ");
                    System.out.println("|====================================|");
                    System.out.println("Por favor, intente nuevamente: ");
                    cantP = sc.nextInt();
                }

                // Variables para la operacion de la venta
                double subtotalV = 0.0;
                int productosDeV = 0;

                // Procesar cada producto
                // Ciclo para registar la cantidad y datos del producto
                for (int i = 1; i <= cantP; i++) {

                    //datos del producto que vamos a ingresar el registro de ventas
                    //imprime cada producto
                    System.out.println("Producto #" + i);

                    //codigo del producto individual
                    System.out.print("Ingrese codigo: ");
                    int codigo = sc.nextInt();

                    //nombre del producto individual
                    System.out.print("Ingrese nombre del producto: ");
                    sc.nextLine();
                    String nombre = sc.nextLine();

                    //precio unitario 
                    System.out.print("Ingrese precio unitario (Q): ");
                    double precio = sc.nextDouble();

                    //while para almacenar el precio del producto 
                    while (precio <= 0) {
                        System.out.println("|====================================|");
                        System.out.println("| El precio debe ser mayor a 0.      |");
                        System.out.println("|====================================|");
                        System.out.println("Por favor, intente de nuevo:");
                        precio = sc.nextDouble();
                    }

                    System.out.print("Ingrese cantidad: ");
                    int cantidad = sc.nextInt();

                    //while para la cantidad de cada producto
                    while (cantidad <= 0) {
                        System.out.println("|====================================|");
                        System.out.println("| La cantidad debe ser mayor a 0.    |");
                        System.out.println("|====================================|");
                        System.out.println("Por favor. Intente nuevamente: ");
                        cantidad = sc.nextInt();
                    }

                    //operacion dentro de variable para reducir procesos
                    double subtotalProducto = precio * cantidad;

                    // Acumulador de UInidades
                    // += sirve para sumar un valor nuevo a un acumulador 
                    subtotalV += subtotalProducto;
                    productosDeV += cantidad;
                }

                // Calcular descuento con el uso de condicionales
                double porcentajeDescuento = 0.0;

                if (subtotalV >= 200 && subtotalV < 500) {
                    porcentajeDescuento = 0.05;
                } else if (subtotalV >= 500 && subtotalV < 1000) {
                    porcentajeDescuento = 0.08;
                } else if (subtotalV >= 1000) {
                    porcentajeDescuento = 0.10;
                }
                
                // Declaración de variables a las que se le debe aplicar el IVA
                // Calcular descuento, IVA y total
                double montoDescuento = subtotalV * porcentajeDescuento;
                double montoConDescuento = subtotalV - montoDescuento;
                double iva = montoConDescuento * 0.12;
                double totalPagar = montoConDescuento + iva;

                // Formas de pago
                // Bucle para presentar como se tendra que operar con el switch 
                System.out.println("|====================================|");
                System.out.println("| Forma de pago:\n                   |");
                System.out.println("| 1 - Efectivo                       |");
                System.out.println("| 2 - Tarjeta                        |");
                System.out.println("| 3 - Transferencia                  |");
                System.out.println("|====================================|");
                System.out.print("Seleccione una opcion de pago: ");

                int formaPago = sc.nextInt();

                while (formaPago < 1 || formaPago > 3) {
                    System.out.println("|====================================|");
                    System.out.println("| Opcion de pago invalida.           |");
                    System.out.println("|====================================|");
                    System.out.println("Seleccione los numeros 1, 2 o 3: ");
                    formaPago = sc.nextInt();
                }

                // Declaracion de variables para el caso de pago en efectivo
                double efectivoRecibido = 0.0;
                double cambio = 0.0;

                // Switch para procesar la forma de pago 
                switch (formaPago) {

                    case 1:
                        // Pago en efectivo
                        System.out.println("|====================================|");
                        System.out.println("| Ingrese el monto en efectivo       |");
                        System.out.println("| recibido Q: ");
                        System.out.println("|====================================|");
                        efectivoRecibido = sc.nextDouble();

                        while (efectivoRecibido < totalPagar) {
                            System.out.println("|====================================|");
                            System.out.print("Efectivo insuficiente. "
                                    + "El total es Q" + totalPagar
                                    + ". Ingrese un monto valido: ");
                            System.out.println("|====================================|");
                            efectivoRecibido = sc.nextDouble();
                        }

                        //opeiracion para dar cambio + acumulador para las cantidades de la forma de pago
                        cambio = efectivoRecibido - totalPagar;
                        vEfectivoT += totalPagar;
                        break;

                    case 2:
                        // Pago con tarjeta
                        vTarjetaT += totalPagar;
                        break;

                    case 3:
                        // Pago por transferencia
                        vTransferenciaT += totalPagar;
                        break;
                }

                // Actualizar estadisticas
                // Uso de acumuladores; 
                totalV++;
                totalP += productosDeV;
                dineroTv += totalPagar;

                // Determinar venta mayor y menor
                // Evita que la venta mayor sea 0
                // La 
                if (primeraV) {
                    ventaMax = totalPagar;
                    ventaMin = totalPagar;
                    primeraV = false;
                } else {
                    if (totalPagar > ventaMax) {
                        ventaMax = totalPagar;
                    }

                    if (totalPagar < ventaMin) {
                        ventaMin = totalPagar;
                    }
                } // Despues de la primera venta 

                // Resumen de la venta
                // Imprimir los datos para consultas
                System.out.println("|====================================|");
                System.out.println("\nRESUMEN DE LA VENTA\n");
                System.out.println("Cantidad de productos: " + productosDeV);
                System.out.println("Subtotal: Q" + subtotalV);
                System.out.println("Descuento aplicado ("
                        + (porcentajeDescuento * 100)
                        + "%): Q" + montoDescuento);
                System.out.println("IVA (12%): Q" + iva);
                System.out.println("TOTAL A PAGAR: Q" + totalPagar);
                System.out.println("|====================================|");

                if (formaPago == 1) {
                    System.out.println("|====================================|");
                    System.out.println("Forma de pago: Efectivo");
                    System.out.println("Efectivo recibido: Q" + efectivoRecibido);
                    System.out.println("Cambio: Q" + cambio);
                    System.out.println("|====================================|");
                } else if (formaPago == 2) {
                    System.out.println("|====================================|");
                    System.out.println("Forma de pago: Tarjeta");
                    System.out.println("|====================================|");
                } else {
                    System.out.println("|====================================|");
                    System.out.println("Forma de pago: Transferencia");
                    System.out.println("|====================================|");
                }

                break;

            case 2:
                System.out.println("|====================================|");
                System.out.println("CONSULTAR CAJA\n");
                System.out.println("|====================================|");

                if (totalV == 0) {
                    System.out.println("|====================================|");
                    System.out.println("No existen ventas registradas.");
                    System.out.println("|====================================|");
                    
                } else {
                    System.out.println("|====================================|");
                    System.out.println("Ventas realizadas: " + totalV);
                    System.out.println("Productos vendidos: " + totalP);
                    System.out.println("Total vendido en caja: Q" + dineroTv);
                    System.out.println("Ventas en efectivo: Q" + vEfectivoT);
                    System.out.println("Ventas con tarjeta: Q" + vTarjetaT);
                    System.out.println("Ventas por transferencia: Q" + vTransferenciaT);
                    System.out.println("|====================================|");
                }

                break;

            case 3:
                System.out.println("|====================================|");
                System.out.println("ESTADISTICAS\n");
                System.out.println("|====================================|");

                if (totalV == 0) {
                    System.out.println("|====================================|");
                    System.out.println("No existen ventas registradas.");
                    System.out.println("|====================================|");
                    
                } else {
                    double promedioVenta = dineroTv / totalV;

                    System.out.println("|====================================|");
                    System.out.println("Numero total de ventas: " + totalV);
                    System.out.println("Cantidad total de productos vendidos: " + totalP);
                    System.out.println("Total de dinero vendido: Q" + dineroTv);
                    System.out.println("Promedio de dinero por venta: Q" + promedioVenta);
                    System.out.println("Venta de mayor valor: Q" + ventaMax);
                    System.out.println("Venta de menor valor: Q" + ventaMin);
                    System.out.println("|====================================|");
                }

                break;

            case 4:
                //Solo mostrar el resultado finaliza el proceso 
                System.out.println("---------------------------------------");
                System.out.println("Saliendo del sistema. !Vuelva pronto!\n");
                break;

            default:
                // Para opciones no validas
                System.out.println("---------------------------------------");
                System.out.println("Opcion no valida. Intente de nuevo.\n");
        }

    } while (opMenu != 4);

    // Cerrar Scanner
    sc.close();
        /**funcion para cerrar el scanner y evitar posibles errores 
        *que se encontraron al estar realizando pruebas con los bucles Do-While*/
    }
}

