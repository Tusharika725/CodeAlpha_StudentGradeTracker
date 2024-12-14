import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Student Grade Tracker!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a grade");
            System.out.println("2. View all grades");
            System.out.println("3. Compute average grade");
            System.out.println("4. Find highest and lowest grades");
            System.out.println("5. Exit");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the grade (0-100): ");
                    int grade = scanner.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully!");
                    } else {
                        System.out.println("Invalid grade! Please enter a value between 0 and 100.");
                    }
                    break;

                case 2:
                    System.out.println("\nGrades:");
                    if (grades.isEmpty()) {
                        System.out.println("No grades recorded yet.");
                    } else {
                        for (int g : grades) {
                            System.out.print(g + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to compute the average.");
                    } else {
                        double average = computeAverage(grades);
                        System.out.printf("The average grade is: %.2f\n", average);
                    }
                    break;

                case 4:
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to find highest and lowest.");
                    } else {
                        int highest = findHighest(grades);
                        int lowest = findLowest(grades);
                        System.out.println("Highest grade: " + highest);
                        System.out.println("Lowest grade: " + lowest);
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to compute the average of grades
    public static double computeAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
