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
import java.util.ArrayList;
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
    Participante computadora1;
    AlgoritmoGenetico algGene;
    ArrayList<String> prueba = new ArrayList<String>();
    int indice;
    
    public Pantalla(){
        
        for(int i=0; i<3; i++){
            prueba.add("down");
            prueba.add("down");
            prueba.add("down");
            prueba.add("down");
            prueba.add("down");
        }
        indice = 0;
        jugador1 = new Participante(false);
        computadora1 = new Participante(true);
       // t = new Timer(50, this);
       // t.start();
        setBackground(Color.WHITE);
        try {
            maze = ImageIO.read(new FileInputStream("Laberintos/maze1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        algGene = new AlgoritmoGenetico(10, computadora1);
        jugador1.parar();
        algGene.run();
        prueba = algGene.mejor().getCodificacion();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(maze, 0, 0, maze.getWidth(), maze.getHeight(), this);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fill(new Ellipse2D.Double(jugador1.x, jugador1.y, 10, 10));
        g2.setColor(Color.yellow);
        g2.fill(new Ellipse2D.Double(computadora1.x, computadora1.y, 10, 10));
      //  System.out.println(computadora1.y);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
        if(algGene.empiece()){
            jugador1.mover();
            if(indice < prueba.size()){
                computadora1.ejecutarComputadora(prueba.get(indice));
                computadora1.mover();
            }
            indice++;
        }
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
        switch(code){
            case KeyEvent.VK_UP:
                if(maze.getRGB(jugador1.x + 5, jugador1.y) == -1 || maze.getRGB(jugador1.x + 5, jugador1.y) == -12629812 || maze.getRGB(jugador1.x + 5, jugador1.y) == -14503604){
                    up();
                }
                break;
            case KeyEvent.VK_DOWN:
                if( maze.getRGB(jugador1.x + 5, jugador1.y + 10) == -1 || maze.getRGB(jugador1.x + 5, jugador1.y + 10) == -12629812 || maze.getRGB(jugador1.x + 5, jugador1.y + 10) == -14503604){
                    down();
                }
                break;
            case KeyEvent.VK_LEFT:
                if(maze.getRGB(jugador1.x, jugador1.y + 5) == -1 || maze.getRGB(jugador1.x, jugador1.y + 5) == -12629812 || maze.getRGB(jugador1.x, jugador1.y + 5) == -14503604){
                    left();
                }                
                break;
            case KeyEvent.VK_RIGHT:
                if(maze.getRGB(jugador1.x + 10, jugador1.y + 5) == -1 || maze.getRGB(jugador1.x + 10, jugador1.y + 5) == -12629812 || maze.getRGB(jugador1.x + 10, jugador1.y + 5) == -14503604){
                    right();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        jugador1.parar();
    }
}
