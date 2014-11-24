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
          
       }
    }
    
    public void generarCodificacion(){
       int total = (int)(Math.random()*(1000-800+1)+800);
       
    }
    
    public int calcularAptitud(){
       int aptitud = 1;
       
       return aptitud;
    }
    
    public String imprimir(){
       String matriz = "";
       
       return matriz;
    }
    
}
