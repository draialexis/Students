/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

import java.util.List;
import java.util.Scanner;
import students.faculties.Faculty;

/**
 *
 * @author aldrai
 */
public class CLI {

    private final University university;
    private final Scanner scanner;

    public CLI(University university, Scanner scanner) {
        this.university = university;
        this.scanner = scanner;
    }

    public void showMenu() {
        boolean isQuitting = false;
        while (!isQuitting) {
            System.out.println();
            switch (requestLine("Menu"
                    + "\n0........to quit this program"
                    + "\n1........to register a student"
                    + "\n2........to show all students"
                    + "\n3........to modify a student"
                    + "\n4........to delete a student")) {

                // CREATE
                case ("1") -> {
                    String fullName = requestLine("enter full name");
                    String dobString = requestLine("enter date of birth (\"yyyy-mm-dd\")");
                    showAllFaculties();
                    registerStudent(
                            Integer.parseInt(requestLine("choose a faculty number")),
                            new Student(dobString, fullName)
                    );
                }

                // READ
                case ("2") -> {
                    showAllStudents();
                }

                // UPDATE
                case ("3") -> {
                    showAllStudents();
                    int studentID = Integer.parseInt(requestLine("chose student (by their student number)"));
                    String fullName = requestLine("enter new full name");
                    modifyStudent(studentID, fullName);
                }

                // DELETE
                case ("4") -> {
                    showAllStudents();
                    int studentID = Integer.parseInt(requestLine("chose student (by their student number)"));
                    deleteStudent(studentID);
                }
                case ("0") -> {
                    isQuitting = true;
                }
                default -> {
                    System.out.println("you must choose between 1 and 4, or quit with 0");
                }
            }
        }
    }

    private void registerStudent(int facultyIdx, Student newStudent) throws IllegalArgumentException {
        this.university.addStudentToFaculty(facultyIdx, newStudent);
    }

    private void showAllStudents() {
        this.university.getFaculties().forEach(e -> {
            for (Student student : e.getStudents()) {
                System.out.println(student);
            }
        });
    }

    private void showAllFaculties() {
        int i = 0;
        for (Faculty faculty : this.university.getFaculties()) {
            System.out.println(i++ + ": " + faculty.getClass().getSimpleName());
        }
    }

//    private void modifyStudent(Student oldStudent, Student newStudent) throws IllegalArgumentException {
//        this.university.updateOne(oldStudent, newStudent);
//    }

    private void modifyStudent(int studentID, String newName){
        this.university.updateOne(studentID, newName);
    }

    private void deleteStudent(int studentID) {
        this.university.deleteOne(studentID);
    }

    private String requestLine(String msg) {
        String input;
        System.out.println(msg);
        input = scanner.nextLine();
        return input;
    }

//    private void warnAndSendBack(Exception e) {
//        System.out.println(e + " " + e.getMessage());
//        showMenu();
//    }
}
