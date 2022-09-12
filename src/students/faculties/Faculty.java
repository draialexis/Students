/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students.faculties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import students.Student;

/**
 *
 * @author aldrai
 */
public abstract class Faculty implements Serializable {

    private final int capacity;
    private List<Student> students;

    public Faculty(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{\ncapacity=" + capacity + ",\nstudents=\n" + students + "\n}";
    }

}
