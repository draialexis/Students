/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.time.LocalDate;
import students.Student;
import students.University;
import students.faculties.Faculty;
import students.faculties.ISIMA;
import students.faculties.IUT;

/**
 *
 * @author aldrai
 */
public class StubLoader implements Loadable {

    University uni;

    @Override
    public University load(String path) {
        uni = new University();

        Faculty iut = new IUT(300);
        Faculty isima = new ISIMA(120);

        uni.addFaculty(iut);
        uni.addFaculty(isima);

        Student me = new Student(LocalDate.parse("1990-04-29"), "Alexis Drai");
        Student ab = new Student(LocalDate.parse("1991-02-15"), "A B");
        Student cd = new Student(LocalDate.parse("1998-07-11"), "C D");
        Student ef = new Student(LocalDate.parse("2001-11-03"), "E F");
        Student gh = new Student(LocalDate.parse("2003-01-24"), "G H");
        Student ij = new Student(LocalDate.parse("1967-04-17"), "I J");
        Student kl = new Student(LocalDate.parse("1624-06-12"), "K L");

        iut.addStudent(me);
        iut.addStudent(ab);
        iut.addStudent(cd);
        iut.addStudent(ef);
        isima.addStudent(gh);
        isima.addStudent(ij);
        isima.addStudent(kl);
        return uni;
    }

}
