package org.example;

import java.util.Scanner;

public class Gasto {
    private double totalGastos;

    public Gasto() {
        this.totalGastos = 0;
    }

    public void pedirGasto(String nombreUsuario, double saldoTotal) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipos de gasto:");
        System.out.println("1.- Vacaciones");
        System.out.println("2.- Alquiler");
        System.out.println("3.- Vicios variados");
        System.out.print("Opcion: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        String concepto = switch (tipo) {
            case 1 -> "Vacaciones";
            case 2 -> "Alquiler";
            case 3 -> "Vicios variados";
            default -> "Otro";
        };

        System.out.print("Introduce cantidad de gasto para " + concepto + ": ");
        double cantidad = scanner.nextDouble();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positivo...");
        } else if (cantidad > saldoTotal) {
            System.out.println("Saldo insuficiente...");
        } else {
            totalGastos += cantidad;
            System.out.println("Gasto de " + cantidad + "€ en " + concepto + " registrado para " + nombreUsuario + ".");
        }
    }

    public double getTotalGastos() {
        return totalGastos;
    }
}
