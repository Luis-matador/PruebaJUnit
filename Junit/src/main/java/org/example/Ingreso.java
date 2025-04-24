package org.example;

import java.util.Scanner;

public class Ingreso {
    private double saldo;

    public Ingreso() {
        this.saldo = 0;
    }

    public void pedirIngreso(String nombreUsuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce cantidad de ingreso: ");
        double cantidad = scanner.nextDouble();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser positiva.");
        } else {
            saldo += cantidad;
        }
    }

    public double getSaldo() {
        return saldo;
    }
}
