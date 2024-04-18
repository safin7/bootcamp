package SchoolManagementSystem;

public class Teacher extends Person {
    private int teacherId;
    private String subject;
    private String classroomAssigned;

    public Teacher(String name, int age, String address, int teacherId, String subject, String classroomAssigned) {
        super(name, age, address);
        this.teacherId = teacherId;
        this.subject = subject;
        this.classroomAssigned = classroomAssigned;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setClassroomAssigned(String classroomAssigned) {
        this.classroomAssigned = classroomAssigned;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public String getClassroomAssigned() {
        return classroomAssigned;
    }

    public void assignClassroom(String classroom) {
        setClassroomAssigned(classroom);
        System.out.println("Classroom  " + classroom + " is assigned to teacher " + getName());
    }
    public void displaySubject() {
        System.out.println("Subject taught: " + getSubject());
    }

}
