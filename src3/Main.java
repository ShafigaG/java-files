import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        try {
            students.add(new Student("0001", "Henry Smith", "henry@example.com", Arrays.asList("Java", "Spring", "Git")));
            students.add(new Student("0002", "Coleen Hughes", "coleen@example.com", Arrays.asList("Python", "Django")));
            students.add(new Student("0003", "", "name@example.com", Arrays.asList("HTML", "CSS", "JavaScript")));
        } catch (InvalidStudentDataException e) {
            System.err.println("Student information is incorrect: " + e.getMessage());
        }

        String fileName = "students.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("ID;Name;Email;Courses");
            writer.newLine();

            for (Student student : students) {
                writer.write(student.toCsvLine());
                writer.newLine();
            }

            System.out.println("Data was successfully written to " + fileName);
        }
        catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
