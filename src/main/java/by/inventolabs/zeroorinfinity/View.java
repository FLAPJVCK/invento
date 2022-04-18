package by.inventolabs.zeroorinfinity;

import java.util.Scanner;

import static by.inventolabs.zeroorinfinity.Logic.*;

public class View {
    public static void main(String[] args) {
        System.out.println("Write n");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n>1){
                System.out.println("un = " + zeroOrInfinity(n));
            } else {
                System.out.println("Error");
            }

        } else {
            System.out.println("Error");
        }
    }
}
