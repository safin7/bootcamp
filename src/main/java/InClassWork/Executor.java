package InClassWork;

import java.util.Scanner;


public class Executor {
    public static void main(String[] args) {
        StudentRoster roster = new StudentRoster();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search a student by name");
            System.out.println("4. Update a student");
            System.out.println("5. Display roster");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student id and name:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    roster.addStudent(id, name);
                    break;
                case 2:
                    System.out.println("Enter student id to remove: ");
                    int removeId = scanner.nextInt();
                    roster.removeStudent(removeId);
                    break;
                case 3:
                    System.out.println("Enter student name to search: ");
                    String searchName = scanner.nextLine().trim();

                    Student student = roster.searchStudentByName(searchName);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter student id:");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    roster.updateStudent(updateId, newName);
                    break;
                case 5:
                    roster.displayRoster();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

