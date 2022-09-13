/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data;

import java.io.IOException;
import students.University;

/**
 *
 * @author aldrai
 */
public interface Savable {

    void save(University university, String path) throws IOException;

}
