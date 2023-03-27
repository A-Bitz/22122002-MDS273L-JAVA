import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Management {

    String regNo;
    String name;
    String email;
    String phone;
    String className;
    String Department;

    Management(String regNo, String name, String email, String phone, String className, String Department) {
        this.regNo = regNo;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.className = className;
        this.Department = Department;
    }

    public void printingDetails() {
        System.out.println("Registration Number: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Class: " + className);
        System.out.println("Department: " + Department);
    }

    public String ConverttoString() {
        return (regNo + "," + name + "," + email + "," + phone + "," + className + "," + Department);

    }

    public void ToFile() {
        String fileName = name + ".txt";
        File file = new File(fileName);

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(ConverttoString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error eerupted  while saving file: " + e.getMessage());
        }
    }

}

public class TEst {
    private static final int MAXi = 100;
    private static Management[] students = new Management[MAXi];
    private static int numStudents = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Update the details of a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    searchStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        if (numStudents >= MAXi) {
            System.out.println("Maximum number of students reached.");
            return;
        }

        System.out.println("Enter registration number:");
        String regNo = scanner.nextLine();

        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter class:");
        String className = scanner.nextLine();

        System.out.println("Enter department:");
        String department = scanner.nextLine();

        Management student = new Management(regNo, name, email, phone, className, department);
        students[numStudents] = student;
        numStudents++;

        System.out.println("Student added successfully.");
        student.ToFile();
    }

    private static void searchStudent(Scanner scanner) {
        System.out.println("Search by (1) Name or (2) Register Number?");
        int searchBy = scanner.nextInt();
        scanner.nextLine();

        if (searchBy == 1) {
            System.out.println("Enter name:");
            String name = scanner.nextLine();

            for (int i = 0; i < numStudents; i++) {
                if (students[i].ConverttoString().contains(name)) {
                    students[i].printingDetails();
                    return;
                }
            }

            System.out.println("Student not found.");
        } else if (searchBy == 2) {
            System.out.println("Enter register number:");
            String regNo = scanner.nextLine();

            for (int i = 0; i < numStudents; i++) {
                if (students[i].toString().contains(regNo)) {
                    students[i].printingDetails();
                    return;
                }
            }

            System.out.println("Student not found.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("Search by (1) Name or (2) Register Number?");
        int searchBy = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        int index = -1;

        if (searchBy == 1) {
            System.out.println("Enter name:");
            String name = scanner.nextLine();

            for (int i = 0; i < numStudents; i++) {
                if (students[i].ConverttoString().contains(name)) {
                    index = i;
                    break;
                }
            }
        } else if (searchBy == 2) {
            System.out.println("Enter register number:");
            String regNo = scanner.nextLine();

            for (int i = 0; i < numStudents; i++) {
                if (students[i].ConverttoString().contains(regNo)) {
                    index = i;
                    break;
                }
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter new registration number:");
        String regNo = scanner.nextLine();

        System.out.println("Enter new name:");
        String name = scanner.nextLine();

        System.out.println("Enter new email:");
        String email = scanner.nextLine();

        System.out.println("Enter new phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter new class:");
        String className = scanner.nextLine();

        System.out.println("Enter new department:");
        String department = scanner.nextLine();

        students[index] = new Management(regNo, name, email, phone, className, department);

        System.out.println("Student details updated successfully.");
        students[index].ToFile();
    }

    private static void displayAllStudents() {
        if (numStudents == 0) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("List of all students:");

        for (int i = 0; i < numStudents; i++) {
            students[i].printingDetails();
        }
    }
}
