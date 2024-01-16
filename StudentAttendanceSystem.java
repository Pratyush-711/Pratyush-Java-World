import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String studentId;
    private String studentName;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }
}

class AttendanceSystem {
    private Map<String, Boolean> attendanceRecords;

    public AttendanceSystem() {
        this.attendanceRecords = new HashMap<>();
    }

    public void markAttendance(Student student, boolean isPresent) {
        attendanceRecords.put(student.getStudentId(), isPresent);
    }

    public void displayAttendance() {
        System.out.println("Attendance Records:");
        for (Map.Entry<String, Boolean> entry : attendanceRecords.entrySet()) {
            Student student = findStudentById(entry.getKey());
            System.out.println("Student ID: " + student.getStudentId() + ", Student Name:" + student.getStudentName() + ", Attendance: " + (entry.getValue() ? "Present" : "Absent"));
        }
    }

    private Student findStudentById(String studentId) {
        Student[] students = {new Student("1001", "Rahul"), new Student("1002", "Ram")};
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }
}

public class StudentAttendanceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceSystem attendanceSystem = new AttendanceSystem();
        Student student1 = new Student("1001", "Rahul");
        Student student2 = new Student("1002", "Ram");
        System.out.print("Is " + student1.getStudentName() + " present? (true/false): ");
        boolean isPresentStudent1 = scanner.nextBoolean();
        attendanceSystem.markAttendance(student1, isPresentStudent1);
        System.out.print("Is " + student2.getStudentName() + " present? (true/false): ");
        boolean isPresentStudent2 = scanner.nextBoolean();
        attendanceSystem.markAttendance(student2, isPresentStudent2);
        attendanceSystem.displayAttendance();
        scanner.close();
    }
}
