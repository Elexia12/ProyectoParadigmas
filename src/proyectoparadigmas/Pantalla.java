/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparadigmas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Xia
 */
public class Pantalla extends JPanel implements ActionListener, KeyListener{
    
    BufferedImage maze;
    Timer t;
    Participante jugador1;
    
    public Pantalla(){
        jugador1 = new Participante(false);
        t = new Timer(50, this);
        t.start();
        setBackground(Color.WHITE);
        try {
            maze = ImageIO.read(new FileInputStream("Laberintos/maze1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(maze, 0, 0, maze.getWidth(), maze.getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(jugador1.x, jugador1.y, 10, 10));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
        jugador1.mover();
    }

    public void up(){
        jugador1.arriba();
    }
    
    public void down(){
        jugador1.abajo();
    }
    
    public void left(){
        jugador1.izquierda();
    }
    
    public void right(){
        jugador1.derecha();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        
        if(code == KeyEvent.VK_UP && maze.getRGB(jugador1.x + 5, jugador1.y) == -1){
            up();
            System.out.println("Color en pos: " + maze.getRGB((int)jugador1.x, (int)jugador1.y));
        }
        if(code == KeyEvent.VK_DOWN && maze.getRGB(jugador1.x + 5, jugador1.y + 10) == -1){
            down();
        }
        if(code == KeyEvent.VK_LEFT && maze.getRGB(jugador1.x, jugador1.y + 5) == -1){
            left();
        }
        if(code == KeyEvent.VK_RIGHT && maze.getRGB(jugador1.x + 10, jugador1.y + 5) == -1){
            right();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        jugador1.parar();
    }
}
