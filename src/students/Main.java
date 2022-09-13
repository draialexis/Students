/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package students;

import data.Loadable;
import data.Loader;
import data.StubLoader;
import data.Savable;
import data.Saver;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author aldrai
 */
public class Main {

    private static University uni;
//    private static final Loadable loader = new StubLoader();
    private static final Loadable loader = new Loader();
    private static final String path = "assets/saves/last_save.sr"; //SHOULD BE IN PROPERTIES

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            uni = loader.load(path);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(String.format("%s\n%s", e, e.getMessage()));
            uni = new StubLoader().load(path);
        }
        System.out.println(uni);

        CLI cli = new CLI(uni, new Scanner(System.in), new Saver(), loader, path);
        cli.showMenu();
    }

}
