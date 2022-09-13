/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import students.faculties.Faculty;

/**
 *
 * @author aldrai
 */
public class University implements Serializable {

    private List<Faculty> faculties;

    public University() {
        this.faculties = new ArrayList();
    }

    public List<Faculty> getFaculties() {
        return Collections.unmodifiableList(faculties);
    }

//    public Faculty addFaculty(Faculty faculty) throws IllegalArgumentException {
//        if (faculty != null) {
//            faculties.add(faculty);
//            return faculty;
//        }
//        throw new IllegalArgumentException("!!>> faculty may not be null");
//    }
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void addStudentToFaculty(int facultyIdx, Student newStudent) {
        faculties.get(facultyIdx).addStudent(newStudent);
    }

//    void updateOne(Student oldStudent, Student newStudent) {
//
//    }
    void updateOne(int studentID, String newName) {
        this.faculties.forEach(f -> {
            f.getStudents().forEach(s -> {
                if (s.getStudentID() == studentID) {
                    s.setFullName(newName);
                }
            });
        });
    }

    @Override
    public String toString() {
        return "University{\n" + "faculties=\n" + faculties + "\n}";
    }

    void deleteOne(int studentID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
