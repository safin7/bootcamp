package SchoolManagementSystem;

public class School {
    private Student[] students;
    private Teacher[] teachers;
    private int studentCount;
    private int teacherCount;

    public School(int studentCapacity, int teacherCapacity) {
        students = new Student[studentCapacity];
        teachers = new Teacher[teacherCapacity];
        studentCount = 0;
        teacherCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("Cannot add more students, limit reached.");
        }
    }

    public void addTeacher(Teacher teacher) {
        if (teacherCount < teachers.length) {
            teachers[teacherCount] = teacher;
            teacherCount++;
        } else {
            System.out.println("Cannot add more teachers, limit reached.");
        }
    }

    public void displayAllStudents() {
        System.out.println("All Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i].getName() + ", ID: " + students[i].getStudentId());
        }
    }

    public void displayAllTeachers() {
        System.out.println("All Teachers:");
        for (int i = 0; i < teacherCount; i++) {
            System.out.println("Name: " + teachers[i].getName() + ", ID: " + teachers[i].getTeacherId() +
                    ", Subject: " + teachers[i].getSubject());

        }
    }

    public Student searchStudentById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == id) {
                return students[i];
            }
        }
        System.out.println("Student not found.");
       return null;
    }

    public Teacher searchTeacherById(int id) {
        for (int i = 0; i < teacherCount; i++) {
            if (teachers[i].getTeacherId() == id) {
                return teachers[i];
            }
        }
        System.out.println("Teacher not found.");
        return null;
    }

}
