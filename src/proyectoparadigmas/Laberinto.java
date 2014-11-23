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
        pantalla = new Pantalla();
        
        titulo = "Maze Runner";
        width = pantalla.maze.getWidth();
        height = pantalla.maze.getHeight() + 25;
        
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
