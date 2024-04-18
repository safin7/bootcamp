package SchoolManagementSystem;

public class Main {
    public static void main(String[] args) {
        School gsu = new School(10, 5);


        Student student1 = new Student("Alice Smith", 14, "123 Maple St", 1001, "9th");
        Student student2 = new Student("Bob Jones", 13, "456 Oak St", 1002, "8th");


        Teacher teacher1 = new Teacher("Mrs. Anderson", 35, "789 Pine St", 5001, "Mathematics","2A");
        Teacher teacher2 = new Teacher("Mr. Brown", 40, "321 Elm St", 5002, "Science","B2");
        ;
        gsu.addStudent(student1);
        gsu.addStudent(student2);


        gsu.addTeacher(teacher1);
        gsu.addTeacher(teacher2);


        student1.enroll("Math 101");
        student1.enroll("Science 101");
        student2.enroll("History 101");
        student2.enroll("English 101");

        student1.displayInfo();
        student2.displayInfo();
        student1.displayCourses();






        teacher1.assignClassroom("Room 101");
        teacher2.assignClassroom("Room 102");
        teacher2.displaySubject();




        gsu.displayAllStudents();


        gsu.displayAllTeachers();

        gsu.searchTeacherById(1001);



    }
}
