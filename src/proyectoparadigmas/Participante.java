/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparadigmas;

import java.util.ArrayList;

/**
 *
 * @author Xia
 */
public class Participante extends Thread{
    
    int x, y; 
    double velx, vely;
    boolean esCompu;
    ArrayList<String> solucion = new ArrayList<String>();
    
    public Participante(boolean computadora, ArrayList<String> movimientos){
        x = 240;
        y = 20;
        velx = 0;
        vely = 0;
        esCompu = computadora;
        
        if(computadora){
            //Cargar la solucion con la que se va a mover, puede ser una lista estatica en otra clase o no se
            solucion = movimientos;
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
    }

    @Override
    public void run() {
        if(esCompu){
            this.ejecutarComputadora();
        }
        
    }
}
