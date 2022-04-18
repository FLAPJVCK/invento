package by.inventolabs.ipaddresses;

import java.util.Scanner;

import static by.inventolabs.ipaddresses.Logic.*;

public class View {
    public static void main(String[] args) {
        System.out.println("Write IpV4 or int32 address");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long ip = scanner.nextLong();
            System.out.println("Address after transformation: " + intToIp(ip));
        } else {
            String ip = scanner.nextLine();
            System.out.println("Address after transformation: " +ipToInt(ip));
        }
    }
}
