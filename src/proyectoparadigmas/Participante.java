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
    }
    
    public void abajo(){
        this.vely = 1;
        velx = 0;
    }
    
    public void izquierda(){
        velx = -0.5;
        vely = 0;
    }
    
    public void derecha(){
        velx = 1;
        vely = 0;
    }
    
    public void ejecutarComputadora(){
        for(String mov : solucion){
            switch(mov){
                case "up":
                    this.arriba();
                    try {
                        Thread.sleep((long)500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "down":
                    this.abajo();
                    try {
                        Thread.sleep((long)500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "left":
                    this.izquierda();
                    try {
                        Thread.sleep((long)500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "right":
                    this.derecha();
                    try {
                        Thread.sleep((long)500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
    }

    @Override
    public void run() {
        if(esCompu){
            try {
                this.ejecutarComputadora();
                Thread.sleep((long)5000);
                System.out.println("Soy computadora");
            } catch (InterruptedException ex) {
                Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
