/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package students;

import data.Loadable;
import data.StubLoader;

/**
 *
 * @author aldrai
 */
public class Main {

    private static University uni;
    private static final Loadable loader = new StubLoader();
//    private static final Loadable loader = new Loader();

    public static void main(String[] args) {
        uni = loader.load();
        System.out.println(uni);
    }

}
