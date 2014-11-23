/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparadigmas;

import javax.swing.Timer;

/**
 *
 * @author Xia
 */
public class Participante {
    
    double x, y, velx, vely;
    
    public Participante(boolean computadora){
        x = 240;
        y = 20;
        velx = 0;
        vely = 0;
        
        if(computadora){
            //Cargar la solucion con la que se va a mover, puede ser una lista estatica en otra clase o no se
        }
    }
    
    public void mover(){
        x += velx;
        y += vely;
    }
    
    public void parar(){
        velx = 0;
        vely = 0;
    }
    
    public void arriba(){
        vely = -0.5;
        velx = 0;
    }
    
    public void abajo(){
        vely = 0.5;
        velx = 0;
    }
    
    public void izquierda(){
        velx = -0.5;
        vely = 0;
    }
    
    public void derecha(){
        velx = 0.5  ;
        vely = 0;
    }
}
