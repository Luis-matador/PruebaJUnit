package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String nombreUsuario = "";

        Ingreso ingreso = new Ingreso();
        Gasto gasto = new Gasto();

        do {
            try {

                System.out.println("\n |MENÚ|");
                System.out.println("1. Introduce nombre de usuario");
                System.out.println("2. Introducir ingreso");
                System.out.println("3. Introducir gasto");
                System.out.println("4. Mostrar saldo");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion != 1 && opcion != 5 && nombreUsuario.isEmpty()) {
                    System.out.println("Primero debes registrarte.");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.print("Usuario: ");
                        nombreUsuario = scanner.nextLine();
                        break;
                    case 2:
                        ingreso.pedirIngreso(nombreUsuario);
                        break;
                    case 3:
                        double saldoDisponible = ingreso.getSaldo() - gasto.getTotalGastos();
                        gasto.pedirGasto(nombreUsuario, saldoDisponible);
                        break;
                    case 4:
                        double saldoTotal = ingreso.getSaldo() - gasto.getTotalGastos();
                        System.out.println("Usuario: " + nombreUsuario);
                        System.out.printf("Saldo actual: €\n", saldoTotal);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                scanner.nextLine(); 
            }
        } while (opcion != 5);

        scanner.close();
    }
}
