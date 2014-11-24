/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoparadigmas;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author b17016
 */
public class Cromosoma {
    
    private ArrayList<String> codificacion;
    private static final double PROB_CRUCE = 0.95;
    private static final double PROB_MUTA = 0.5;
    private static final int AZUL = Color.BLUE.getRGB();
    private static final int VERDE = Color.GREEN.getRGB();
    private int posIniX, posIniY, posFinX, posFinY;
    private int mLaberinto[][];
    
    public Cromosoma(){
        codificacion = new ArrayList<String>();
        posIniX = 240;
        posIniY = 20;
        posFinX = 265;
        posFinY = 372;
    }
        
    public ArrayList<String> getCodificacion(){
       return codificacion;
    }
    
    
    public void obtenerMatriz(BufferedImage m){
        mLaberinto = new int[m.getHeight()][m.getWidth()];
        for(int i=0; i<mLaberinto.length; i++){
            for(int j=0; j<mLaberinto[0].length; j++){
                mLaberinto[i][j] = m.getRGB(i, j);
            }
        }
    }
    
    public void cruce(Cromosoma padre, Cromosoma madre){
       double prob = Math.random();
       ArrayList<String> codificacionPadre = padre.getCodificacion();
       ArrayList<String> codificacionMadre = madre.getCodificacion();
       if(prob < PROB_CRUCE){
          int primero = (int)(Math.random()*2);
          int tamanoPadre = (int)(codificacionPadre.size()/2);
          int tamanoMadre = (int)(codificacionMadre.size()/2);
          int menor = tamanoPadre;
          if(tamanoMadre < menor){
             menor = tamanoMadre;
          }
          int contador = 0;
          switch(primero){
              case 0:
                  //primero el padre
                  for(contador = 0; contador < menor; ++contador){
                     codificacion.add(codificacionPadre.get(contador));
                  }
                  for(contador = contador; contador < codificacionMadre.size(); ++contador){
                     codificacion.add(codificacionMadre.get(contador));
                  }
              break;
              case 1:
                  //segundo la madre
                  for(contador = 0; contador < menor; ++contador){
                     codificacion.add(codificacionMadre.get(contador));
                  }
                  for(contador = contador; contador < codificacionPadre.size(); ++contador){
                     codificacion.add(codificacionPadre.get(contador));
                  }
              break;
          }
       }
       else{
          int copia = (int)(Math.random()*2);
          switch(copia){
              case 0:
                  //copia del padre
                  for(int i = 0; i < codificacionPadre.size(); ++i){
                     codificacion.add(codificacionPadre.get(i));
                  }
              break;
              case 1:
                  //copia de la madre
                  for(int i = 0; i < codificacionMadre.size(); ++i){
                     codificacion.add(codificacionMadre.get(i));
                  }
              break;
          }
       }
    }
    
    public void mutacion(){
       String temp = "";
       double prob = Math.random();
       if(prob < PROB_MUTA){
          int pos = (int)(Math.random()*codificacion.size());
          int direccion = (int)(Math.random()*4);
          switch(direccion){
              case 0:
                  codificacion.set(pos, "up");
              break;
              case 1:
                  codificacion.set(pos, "down");
              break;
              case 2:
                  codificacion.set(pos, "left");
              break;
              case 3:
                  codificacion.set(pos, "right");
              break;
          }
       }
    }
    
    public void generarCodificacion(){
       int total = (int)(Math.random()*(5000-800+1)+800);
       int direccion = 0;
       for(int i = 0; i < total; ++i){
          direccion = (int)(Math.random()*4);
          switch(direccion){
              case 0:
                  codificacion.add("up");
              break;
              case 1:
                  codificacion.add("down");
              break;
              case 2:
                  codificacion.add("left");
              break;
              case 3:
                  codificacion.add("right");
              break;
          }
       }
    }
    
    public int calcularAptitud(){
       int aptitud = 1;
       int cromFinX = 0;
       int cromFinY = 0;
       for(String mov : codificacion){
           if(mov != null){
            switch(mov){
                case "up":
                     cromFinY -= 1;  
                     break;
                 case "down":
                     cromFinY += 1;
                     break;
                 case "left":
                     cromFinX -= 1;  
                     break;
                 case "right":
                     cromFinX += 1; 
                     break;
            }
           }
       }
       //Diferencia entre el final deseado y el obtenido por el cromosoma
       aptitud = (cromFinX + posFinX) - (cromFinY +posFinY);
       return aptitud;
    }
}