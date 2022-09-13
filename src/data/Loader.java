/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
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
    public University load(String path) throws IOException, FileNotFoundException, ClassNotFoundException {
        University university = null;
        try ( ObjectInputStream stream = new ObjectInputStream(new FileInputStream(path))) {
            university = (University) stream.readObject();
        }
        if (university == null) {
            System.out.println("!> there was a problem loading a university");

        }
        return university;
    }
}
