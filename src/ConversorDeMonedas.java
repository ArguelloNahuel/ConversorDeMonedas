import java.util.Scanner;

public class ConversorDeMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú principal
        do {
            System.out.println("Conversor de Monedas");
            System.out.println("1. Convertir de Pesos a Dólares");
            System.out.println("2. Convertir de Pesos a Reales");
            System.out.println("3. Convertir de Dólares a Pesos");
            System.out.println("4. Convertir de Reales a Pesos");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            double cantidad, resultado;

            switch (opcion) {
                case 1:
                    System.out.print("Introduce la cantidad en Pesos: ");
                    cantidad = scanner.nextDouble();
                    resultado = MonedaConverter.convertirMoneda(cantidad, "USD");
                    if (resultado != -1) {
                        System.out.printf("%.2f Pesos son %.2f Dólares.\n", cantidad, resultado);
                    }
                    break;
                case 2:
                    System.out.print("Introduce la cantidad en Pesos: ");
                    cantidad = scanner.nextDouble();
                    resultado = MonedaConverter.convertirMoneda(cantidad, "BRL");
                    if (resultado != -1) {
                        System.out.printf("%.2f Pesos son %.2f Reales.\n", cantidad, resultado);
                    }
                    break;
                case 3:
                    System.out.print("Introduce la cantidad en Dólares: ");
                    cantidad = scanner.nextDouble();
                    resultado = MonedaConverter.convertirMoneda(cantidad, "MXN");
                    if (resultado != -1) {
                        System.out.printf("%.2f Dólares son %.2f Pesos.\n", cantidad, resultado);
                    }
                    break;
                case 4:
                    System.out.print("Introduce la cantidad en Reales: ");
                    cantidad = scanner.nextDouble();
                    resultado = MonedaConverter.convertirMoneda(cantidad, "MXN");
                    if (resultado != -1) {
                        System.out.printf("%.2f Reales son %.2f Pesos.\n", cantidad, resultado);
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
