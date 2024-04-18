package InClassWork;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentRoster {
    private ArrayList<Student> roster;

    public StudentRoster() {
        roster = new ArrayList<>();
    }

    public void addStudent(int id, String name) {
        roster.add(new Student(id, name));
    }

    public void removeStudent(int id, String name){

    }
    public boolean removeStudent(int id) {
        Iterator<Student> it = roster.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            if (student.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    public Student searchStudent(int id) {
        for (Student student : roster) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean updateStudent(int id, String newName) {
        for (Student student : roster) {
            if (student.getId() == id) {
                student.setName(newName);
                return true;
            }
        }
        return false;
    }
    public Student searchStudentByName(String name) {
        for (Student student : roster) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
    public void displayRoster() {
        if (roster.isEmpty()) {
            System.out.println("The roster is empty.");
        } else {
            for (Student student : roster) {
                System.out.println(student);
            }
        }
    }

}
