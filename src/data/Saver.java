/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import students.University;

/**
 *
 * @author aldrai
 */
public class Saver implements Savable {

    @Override
    public void save(University university) throws IOException {
        try ( ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("last-save.bin")))) {
            stream.writeObject(university);
        }
    }

}
