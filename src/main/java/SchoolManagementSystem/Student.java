package SchoolManagementSystem;

public class Student extends Person {
    private int studentId;
    private String grade;
    private String[] coursesTaken = new String[5];
    private int numberOfCourses = 0;

    public Student(String name, int age, String address, int studentId, String grade) {
        super(name, age, address);
        this.studentId = studentId;
        this.grade = grade;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCoursesTaken(String[] coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getGrade() {
        return grade;
    }

    public String[] getCoursesTaken() {
        return coursesTaken;
    }

    public void enroll(String course) {
        if (numberOfCourses < coursesTaken.length) {
            coursesTaken[numberOfCourses] = course;
            numberOfCourses++;
        } else {
            System.out.println("Cannot enroll in more courses. Maximum capacity reached.");
        }
    }

    public void displayCourses() {
        for (int i = 0; i < numberOfCourses; i++) {
            System.out.println(coursesTaken[i]);
        }
    }
}
