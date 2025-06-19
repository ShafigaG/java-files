import java.util.List;

public class Student {
    private final String studentId;
    private final String studentName;
    private final String studentEmailAddress;
    private final List<String> enrolledCourses;

    public Student(String studentId, String studentName, String studentEmailAddress, List<String> enrolledCourses) throws InvalidStudentDataException {
        if (studentId == null || studentId.isEmpty()) {
            throw new InvalidStudentDataException("Id cannot be empty.");
        }
        if (studentName == null || studentName.isEmpty()) {
            throw new InvalidStudentDataException("Name cannot be empty.");
        }
        if (studentEmailAddress == null || studentEmailAddress.isEmpty()) {
            throw new InvalidStudentDataException("Email address cannot be empty.");
        }
        if (enrolledCourses == null || enrolledCourses.isEmpty()) {
            throw new InvalidStudentDataException("Courses list cannot be empty.");
        }

        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmailAddress = studentEmailAddress;
        this.enrolledCourses = enrolledCourses;
    }

    public String getCoursesAsString() {
        return String.join(",", enrolledCourses);
    }

    public String toCsvLine() {
        return studentId + ";" + studentName + ";" + studentEmailAddress + ";" + getCoursesAsString();
    }

}
