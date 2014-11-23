/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparadigmas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Xia
 */
public class Pantalla extends JPanel{
    
    BufferedImage maze;
    
    public Pantalla(){
        setBackground(Color.WHITE);
        try {
            maze = ImageIO.read(new FileInputStream("Laberintos/maze1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void paint (Graphics g){
        g.drawImage(maze, 0, 0, maze.getWidth(), maze.getHeight(), this);
    }
}
