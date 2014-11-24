/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoparadigmas;

import java.util.ArrayList;

/**
 *
 * @author b17016
 */
public class Cromosoma {
    
    private ArrayList<String> codificacion;
    private static final double PROB_CRUCE = 0.95;
    private static final double PROB_MUTA = 0.05;
    
    public Cromosoma(){
        codificacion = new ArrayList<String>();
    }
        
    public ArrayList<String> getCodificacion(){
       return codificacion;
    }
    
    public void cruce(Cromosoma padre, Cromosoma madre){
       double prob = Math.random();
       if(prob < PROB_CRUCE){
          
       }
       else{
          
       }
    }
    
    public void mutacion(){
       String temp = "";
       double prob = Math.random();
       if(prob < PROB_MUTA){
          int pos = (int)(Math.random()*codificacion.size());
          int direccion = (int)(Math.random()*(4-1+1)+1);
          switch(direccion){
              case 1:
                  codificacion.set(pos, "up");
              break;
              case 2:
                  codificacion.set(pos, "down");
              break;
              case 3:
                  codificacion.set(pos, "left");
              break;
              case 4:
                  codificacion.set(pos, "right");
              break;
          }
       }
    }
    
    public void generarCodificacion(){
       int total = (int)(Math.random()*(1000-800+1)+800);
       int direccion = 0;
       for(int i = 0; i < total; ++i){
          direccion = (int)(Math.random()*(4-1+1)+1);
          switch(direccion){
              case 1:
                  codificacion.add("up");
              break;
              case 2:
                  codificacion.add("down");
              break;
              case 3:
                  codificacion.add("left");
              break;
              case 4:
                  codificacion.add("right");
              break;
          }
       }
    }
    
    public int calcularAptitud(){
       int aptitud = 1;
       
       return aptitud;
    }
}