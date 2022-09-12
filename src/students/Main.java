/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package students;

import data.Loadable;
import data.Loader;
import data.StubLoader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aldrai
 */
public class Main {

    private static University uni;
//    private static final Loadable loader = new StubLoader();
    private static final Loadable loader = new Loader();

    public static void main(String[] args) {
        try {
            uni = loader.load();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(String.format("%s\n%s", e, e.getMessage()));
            uni = new StubLoader().load();
        }
        System.out.println(uni);
        
        CLI cli = new CLI(uni, new Scanner(System.in));
        cli.showMenu();
    }

}
