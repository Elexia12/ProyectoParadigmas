/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparadigmas;

import javax.swing.JFrame;

/**
 *
 * @author Xia
 */
public class Laberinto {
    
    JFrame frame;
    Pantalla pantalla;
    public static String titulo;
    public static int width;
    public static int height;
    
    public Laberinto(){
        titulo = "Maze Runner";
        width = 800;
        height = 600;
        
        pantalla = new Pantalla();
        
        frame = new JFrame();
        frame.setTitle(titulo);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(pantalla);
        frame.setVisible(true);
    }
}
