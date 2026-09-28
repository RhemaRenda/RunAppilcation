/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.runapplication;

/**
 *
 * @author Student
 */
import java.util.Scanner;

interface IConsoles {
    String getConsoleType();
    String getStore();
    int getTotalSales();
}

abstract class Console implements IConsoles {
    private String consoleType;
    private String store;
    private int totalSales;

    public Console(String consoleType, String store, int totalSales) {
        this.consoleType = consoleType;
        this.store = store;
        this.totalSales = totalSales;
    }

    @Override
    public String getConsoleType() {
        return consoleType;
    }

    @Override
    public String getStore() {
        return store;
    }

    @Override
    public int getTotalSales() {
        return totalSales;
    }
}

class ConsoleSales extends Console {
    public ConsoleSales(String consoleType, String store, int totalSales) {
        super(consoleType, store, totalSales);
    }

    public void printReport() {
        System.out.println("******************************");
        System.out.println("CONSOLE SALES REPORT");
        System.out.println("******************************");
        System.out.println("CONSOLE TYPE: " + getConsoleType());
        System.out.println("STORE: " + getStore());
        System.out.println("TOTAL SALES: " + getTotalSales());
    }
}

public class RunApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select the console type:");
        System.out.println("1) PS5");
        System.out.println("2) XBOX");
        System.out.println("3) SWITCH");
        System.out.print("Choice: ");

        int choice = input.nextInt();
        input.nextLine();

        String consoleType;

        if (choice == 1) {
            consoleType = "PS5";
        } else if (choice == 2) {
            consoleType = "XBOX";
        } else if (choice == 3) {
            consoleType = "SWITCH";
        } else {
            System.out.println("Invalid console choice.");
            input.close();
            return;
        }

        System.out.print("Enter the store name: ");
        String store = input.nextLine();

        System.out.print("Enter the total sales: ");
        int totalSales = input.nextInt();

        ConsoleSales report = new ConsoleSales(
                consoleType, store, totalSales
        );

        System.out.println();
        report.printReport();

        input.close();
    }
}