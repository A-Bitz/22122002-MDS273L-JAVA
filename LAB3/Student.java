package LAB3;


import java.util.Scanner;

public class Student {
    
    static String[][] Details = new String[1024][5];
    
    static String[] Names = new String[1024];
    
    static int sCount = 0;

    
    public static int sName(String name) {
        for (int i = 0; i < sCount; i++) {
            if (Names[i] != null && Names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void displayDetails() {
        Scanner input = new Scanner(System.in);
        String name;
        System.out.print("Enter student name: ");
        name = input.nextLine();
        int index = sName(name);
        if (index == -1) {
            System.out.println("Student with name '" + name + "' not found.");
            return;
        }
        System.out.println("Name: " + Details[index][0]);
        System.out.println("Register Number: " + Details[index][1]);
        System.out.println("Email: " + Details[index][2]);
        System.out.println("Class: " + Details[index][3]);
        System.out.println("Department: " + Details[index][4]);
    }

    public static void searchDetails() {
        Scanner sc = new Scanner(System.in);
        String searchStr;
        System.out.print("Enter search string: ");
        searchStr = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < sCount; i++) {
            if (Details[i][0].contains(searchStr) || Details[i][1].contains(searchStr) || 
                    Details[i][2].contains(searchStr) || Details[i][3].contains

                    (searchStr) || Details[i][4].contains(searchStr)) {
                        System.out.println("Name: " + Details[i][0]);
                        System.out.println("Register Number: " + Details[i][1]);
                        System.out.println("Email: " + Details[i][2]);
                        System.out.println("Class: " + Details[i][3]);
                        System.out.println("Department: " + Details[i][4]);
                        System.out.println();
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No student details found for search string '" + searchStr + "'.");
                }
            }

            public static void collectDetails() {
                Scanner sc = new Scanner(System.in);
                String name, regNo, email, cls, dept;
                System.out.print("Enter student name: ");
                name = sc.nextLine();
                if (sName(name) != -1) {
                    System.out.println("Student with name '" + name + "' already exists.");
                    return;
                }
                System.out.print("Enter register number: ");
                regNo = sc.nextLine();
                System.out.print("Enter email: ");
                email = sc.nextLine();
                System.out.print("Enter class: ");
                cls = sc.nextLine();
                System.out.print("Enter department: ");
                dept = sc.nextLine();
                Details[sCount][0] = name;
                Details[sCount][1] = regNo;
                Details[sCount][2] = email;
                Details[sCount][3] = cls;
                Details[sCount][4] = dept;
                Names[sCount] = name;
                sCount++;
                System.out.println("Student details added successfully.");
            }

   
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Collect student detailsc:");
                System.out.println("2. Display student details");
                System.out.println("3. Search for student details");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
    
                switch (choice) {
                    case 1:
                        collectDetails();
                        break;
                    case 2:
                        displayDetails();
                        break;
                    case 3:
                        searchDetails();
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println();
            } while (choice != 4);
        }

    }