import java.util.ArrayList;
import java.util.Scanner;

    class student {
     String name;
    String id;
    double[] grades = new double[3];
    double average;
    String remark;

      // Constructor
    student(String name, String id, double[] grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;

        computeAverage();

        determineRemark();

    }
    // Compute average grade
    void computeAverage() {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        average = sum / grades.length;
    }
     // Determine remark
    void determineRemark() {
        if (average >= 90)
            remark = "Excellent";
        else if (average >= 80)
            remark = "Very Good";
        else if (average >= 70)
            remark = "Good";
        else if (average >= 60)
            remark = "Needs Improvement";
        else
            remark = "Fail";
    }
}

public class studentmanagemant {
    
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<student> students = new ArrayList<>();


    public static void main(String[] args) {
        
        int choice;

        do {
            showMenu();
            choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 3);
    }

     // Display menu
    static void showMenu() {
        System.out.println("\nSTUDENT GRADE MANAGEMENT SYSTEM");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Exit");
    }
    // Add a new student

    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        double[] grades = new double[3];

        for (int i = 0; i < 3; i++) {
            grades[i] = getGradeInput("Enter grade for subject " + (i + 1) + ": ");
        }

        students.add(new student(name, id, grades));
        System.out.println("Student added successfully!");
    }
    // Display all students
    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-15s %-10s %-10s %-20s%n",
                "Name", "ID", "Average", "Remark");
        System.out.println("-------------------------------------------------------------");

        for (student s : students) {
            System.out.printf("%-15s %-10s %-10.2f %-20s%n",
                    s.name, s.id, s.average, s.remark);
        }
    }
    // Get valid grade input
     // Input validation for menu choice
    static int getIntInput(String message) {
        int value;
        while (true) {
            System.out.print(message);
            try {
                value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    static double getGradeInput(String message) {
        double grade;
        while (true) {
            System.out.print(message);
            try {
                grade = Double.parseDouble(scanner.nextLine());
                if (grade >= 0 && grade <= 100) {
                    return grade;
                } else {
                    System.out.println("Grade must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid grade.");
            }
        }
    }
}

    
    
      