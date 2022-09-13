/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author aldrai
 */
public class Student implements Serializable {

    private static int nextID = 1;

    private final LocalDate dob;
    private String fullName;
    private final int studentID;

    public Student(LocalDate dob, String fullName) {
        this.dob = dob;
        this.fullName = fullName;
        this.studentID = nextID++; //auto-increments the ID
    }
    
    public Student(String dobString, String fullName) {
        this.dob = LocalDate.parse(dobString);
        this.fullName = fullName;
        this.studentID = nextID++; //auto-increments the ID
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getFullName() {
        return fullName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Student{\n" + "dob=" + dob + ",\nfullName=" + fullName + ",\nstudentID=" + studentID + "\n}";
    }

}
