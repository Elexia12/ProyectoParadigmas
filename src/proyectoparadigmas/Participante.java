/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparadigmas;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xia
 */
public class Participante extends Thread{
    
    int x, y; 
    double velx, vely;
    boolean esCompu;
    int numMovs;
    ArrayList<String> solucion = new ArrayList<String>();
    
    public Participante(boolean computadora, ArrayList<String> movimientos){
        x = 240;
        y = 20;
        velx = 0;
        vely = 0;
        numMovs = 0;
        esCompu = computadora;
        
        if(computadora){
            //Cargar la solucion con la que se va a mover, puede ser una lista estatica en otra clase o no se
            solucion = movimientos;
            numMovs = solucion.size();
        }
    }
    
   /* public boolean colision(int pixel1, int pixel2){
        boolean hayColision = false;
        if(pixel1 != )
        return hayColision;
    }*/
    
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
        numMovs++;
    }
    
    public void abajo(){
        vely = 1;
        velx = 0;
        numMovs++;
    }
    
    public void izquierda(){
        velx = -0.5;
        vely = 0;
        numMovs++;
    }
    
    public void derecha(){
        velx = 1;
        vely = 0;
        numMovs++;
    }
    
    public void ejecutarComputadora(String mov){
            switch(mov){
                case "up":
                    this.arriba();
                    break;
                case "down":
                    this.abajo();
                    break;
                case "left":
                    this.izquierda();
                    break;
                case "right":
                    this.derecha();
                    break;
            }
        }
    

    @Override
    public void run() {
        for(String mov : solucion){
            if(esCompu){
                this.ejecutarComputadora(mov);
            }
        }
    }
}
