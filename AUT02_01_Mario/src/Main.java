import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("""
        ===== Student Manager =====
        1. Add student
        2. List students
        3. Find student by name
        4. Calculate average of all scores
        5. Show best student
        6. Exit
        """);

            while (true) {
                System.out.print("Select an option (1 - 6): ");
                String input = sc.nextLine();

                try {
                    option = Integer.parseInt(input);
                    if (option >= 1 && option <= 6) {
                        break;
                    } else {
                        System.out.println("Error: Please enter a number between 1 and 6.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            }

            switch(option) {
                case 1 -> addStudent(sc);
                case 2 -> listStudents();
                case 3 -> findStudent(sc);
                case 4 -> calculateAvg();
                case 5 -> showBestStudent();
                case 6 -> System.out.println("Exiting program...");
            }

        } while (option != 6);

        sc.close();
    }


    private static void addStudent(Scanner sc) {
        String name = "";
        while (true) {
            System.out.print("Enter name: ");
            name = sc.nextLine();
            if (!name.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid name, try again.");
            }
        }

        int age = -1;
        while (true) {
            System.out.print("Enter age: ");
            age = Integer.parseInt(sc.nextLine());
            if (age > 0 && age <= 200) {
                break;
            } else {
                System.out.println("Invalid age. Try again.");
            }
        }


        System.out.print("Enter average score: ");
        double score = Double.parseDouble(sc.nextLine());

        boolean enrolled = false;
        do {
            System.out.print("Is the student enrolled? (Y/N): ");
            String answer = sc.nextLine().trim();

            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                enrolled = true;
                break;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                enrolled = false;
                break;
            } else {
                System.out.println("invalid input, try again");
            }
        } while (true);

        students.add(new Student(name, age, score, enrolled));
    }

    private static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students registered yet.");
        } else {
            System.out.println("Student list: ");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void findStudent(Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("\nError, student list is empty.");
            return;
        }

        System.out.print("Enter student name to search: ");
        String searchName = sc.nextLine().trim();

        boolean found = false;
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(searchName)) {
                System.out.println("Student found: " + s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void calculateAvg() {
        if (students.isEmpty()) {
            System.out.println("\nError, student list is empty.");
        } else {
            double total = 0;
            for (Student s : students) {
                total += s.getScore();
            }

            double average = total / students.size();

            System.out.println("Average score is: " + average);
        }
    }

    private static void showBestStudent() {
        if (students.isEmpty()) {
            System.out.println("\nError, student list is empty.");
        } else {
            Student best = students.get(0);
            for (Student s : students) {
                if (s.getScore() > best.getScore()) {
                    best = s;
                }
            }
            System.out.println("The best student is: " + best);
        }
    }
}