/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import java.io.FileNotFoundException;
import java.io.IOException;
import students.University;

/**
 *
 * @author aldrai
 */
public interface Loadable {

    University load(String path) throws IOException, FileNotFoundException, ClassNotFoundException;
}
