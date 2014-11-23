/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoparadigmas;

/**
 *
 * @author b17016
 */
public class Cromosoma {
    
    private String cuadroMagico;
    private int dimension;
    private double numeroMagico;
    private static final double PROB_CRUCE = 0.95;
    private static final double PROB_MUTA = 0.05;
    
    public Cromosoma(int dimension){
        this.dimension = dimension;
        numeroMagico = 0;
        cuadroMagico = "";
    }
    
    public double getNumeroMagico(){
       return numeroMagico;
    }
    
    public String getCuadroMagico(){
       return cuadroMagico;
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
       
    }
    
    public void generarCuadroMagico(){
       
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
