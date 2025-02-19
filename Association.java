import java.util.ArrayList;
import java.util.List;

public class Association {

    // Kelas Student
    static class Student {
        private String name;
        private List<Course> coursesTaken;

        public Student(String name) {
            this.name = name;
            this.coursesTaken = new ArrayList<>();
        }

        public void enrollInCourse(Course course) {
            coursesTaken.add(course);
        }

        public List<Course> getCoursesTaken() {
            return new ArrayList<>(coursesTaken);
        }
    }

    // Kelas Course
    static class Course {
        private String courseName;

        public Course(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseName() {
            return courseName;
        }
    }

    // Metode main untuk menjalankan contoh Association
    public static void main(String[] args) {
        Student student = new Student("Alice");
        Course math = new Course("Mathematics");
        student.enrollInCourse(math);
        System.out.println(student.getCoursesTaken().get(0).getCourseName()); // Output: Mathematics
    }
}