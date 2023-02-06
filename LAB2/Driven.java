package LAB2;

import java.util.Scanner;

public class Driven {
    static String[] names = new String[1024];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Enter a name");
            System.out.println("2. Search for a name");
            System.out.println("3. Remove a name");
            System.out.println("4. Exit");
            System.out.print("Enter an option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    addName(sc);
                    break;
                case 2:
                    searchName(sc);
                    break;
                case 3:
                    removeName(sc);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        sc.close();
    }

    public static void addName(Scanner sc) {
        System.out.print("Enter a name: ");
        String name = sc.next();

        if (count == 1024) {
            System.out.println("Array is full. Can't add more names.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                System.out.println("Name already exists. Try a different name.");
                return;
            }
        }

        names[count++] = name;
        System.out.println("Name added successfully.");
    }

    public static void searchName(Scanner sc) {
        System.out.print("Enter a name to search: ");
        String name = sc.next();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Name not found.");
        } else {
            System.out.println("Name found at index " + index);
        }
    }

    public static void removeName(Scanner sc) {
        System.out.print("Enter a name to remove: ");
        String name = sc.next();

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Name not found.");
        } else {
            for (int i = index; i < count - 1; i++) {
                names[i] = names[i + 1];
            }
            count--;
            System.out.println("Name removed successfully.");
        }
    }
}
