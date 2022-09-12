/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import students.University;

/**
 *
 * @author aldrai
 */
public class Loader implements Loadable {

    @Override
    public University load() throws IOException, FileNotFoundException, ClassNotFoundException {
        University university = new University();
        try ( ObjectInputStream stream = new ObjectInputStream(new FileInputStream("last-save.bin"))) {
            university = (University) stream.readObject();
        }
        return university;
    }

}
