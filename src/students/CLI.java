/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students;

import data.Loadable;
import data.Savable;
import java.io.IOException;
import java.util.Scanner;
import students.faculties.Faculty;

/**
 *
 * @author aldrai
 */
public class CLI {

    private University university;
    private final Scanner scanner;
    private final Savable saver;
    private final Loadable loader;
    private final String path;
    
    public CLI(University university, Scanner scanner, Savable saver, Loadable loader, String path) {
        this.university = university;
        this.scanner = scanner;
        this.saver = saver;
        this.loader = loader;
        this.path = path;
    }

    public void showMenu() {
        boolean isQuitting = false;
        while (!isQuitting) {
            System.out.println();
            switch (requestLine("Menu"
                    + "\n0........to quit this program"
                    + "\n1........to register a student"
                    + "\n2........to show all students"
                    + "\n3........to show all faculties + students"
                    + "\n4........to modify a student"
                    + "\n5........to delete a student"
                    + "\ns........to save all data"
                    + "\nl........to reload")) {

                // CREATE
                case ("1") -> {
                    String fullName = requestLine("enter full name");
                    String dobString = requestLine("enter date of birth (\"yyyy-mm-dd\")");
                    showAllFaculties(false);
                    registerStudent(
                            Integer.parseInt(requestLine("choose a faculty number")),
                            new Student(dobString, fullName)
                    );
                }

                // READ
                case ("2") -> {
                    showAllStudents();
                }

                // READ MORE
                case ("3") -> {
                    showAllFaculties(true);
                }

                // UPDATE
                case ("4") -> {
                    showAllStudents();
                    int studentID = Integer.parseInt(requestLine("chose student (by their student number)"));
                    String fullName = requestLine("enter new full name");
                    modifyStudent(studentID, fullName);
                }

                // DELETE
                case ("5") -> {
                    showAllStudents();
                    int studentID = Integer.parseInt(requestLine("chose student (by their student ID)"));
                    deleteStudent(studentID);
                }
                case ("s") -> {
                    try {
                        saver.save(university, path);
                    } catch (IOException e) {
//                    Logger.getLogger(CLI.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println(e + " " + e.getMessage());
                    }
                }
                case ("l") -> {
                    try {
                        university = loader.load(path);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println(e + " " + e.getMessage());
                    }
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
            e.getStudents().forEach(System.out::println);
        });
    }

    private void showAllFaculties(boolean andStudents) {
        int i = 0;
        for (Faculty faculty : this.university.getFaculties()) {
            System.out.println("\n" + i + ": " + faculty.getClass().getSimpleName());
            i++;
            if (andStudents) {
                faculty.getStudents().forEach(System.out::println);
            }
        }
    }

//    private void modifyStudent(Student oldStudent, Student newStudent) throws IllegalArgumentException {
//        this.university.updateOne(oldStudent, newStudent);
//    }
    private void modifyStudent(int studentID, String newName) {
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
