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
public class AlgoritmoGenetico extends Thread{
    
    private Cromosoma[] poblacion;
    private static final int individuos = 100;
    private int[] aptitud;
    private int[] padres;
    private boolean[] progenitor;
    private int ciclo = 1;
    private int dimension;
    
    public AlgoritmoGenetico(int dimension) {
        this.dimension = dimension;
        poblacion = new Cromosoma[individuos];
        aptitud = new int[individuos];
        padres = new int[individuos];
        progenitor = new boolean[individuos];
        this.start();
    }
    
    private void algoritmo(){
       Cromosoma mejor;
       int max = 1;
       for(int i = 0; i < individuos; ++i){
          poblacion[i] = new Cromosoma(this.dimension);
          poblacion[i].generarCuadroMagico();
       }
       calcularAptitud();
       ordenar();
       mejor = mejor();
       ++ciclo;
       while(aptitud[individuos-1] != 2*dimension+16){
          max = 1;
          // seleccion de padres y cruce
          Cromosoma[] hijos = new Cromosoma[50];
          for(int i = 0; i < 50; ++i){
             for(int j = 0; j < individuos; ++j){
                // seleccion de padres
                padres[j] = aptitud[j]*(j+1);
                max += aptitud[j]*(j+1);
                progenitor[j] = true;
             }
             hijos[i] = new Cromosoma(dimension);
             hijos[i].cruce(seleccionarPadres(max),seleccionarPadres(max));
             //mutacion
             hijos[i].mutacion();
          }
          //sustitucion de individuos
          sustitucion(hijos);
          calcularAptitud();
          ordenar();
          mejor = mejor();
          ++ciclo;
       }
    }
    
    private void sustitucion(Cromosoma[] hijos){
       for(int i = 0; i < 50; ++i){
          poblacion[i] = hijos[i];
       }
    }
    
    private Cromosoma seleccionarPadres(int max){
       int azar = 0;
       Cromosoma padre;
       azar = (int) (Math.random()*max);
       int i = 0;
       for(i = 0; i < individuos-1 && padres[i] < azar; ++i){}
       if(progenitor[i]){
          progenitor[i] = false;
          padre = poblacion[i];
       }
       else{
          progenitor[(i+1)%individuos] = false;
          padre = poblacion[(i+1)%individuos];
       }
       return padre;
    }
    
    private void calcularAptitud(){
       for(int i = 0; i < individuos; ++i){
          aptitud[i] = poblacion[i].calcularAptitud();
       }
    }
    
    private void ordenar(){
       int m = 0;
       int j = 0;
       for(int i = 0; i < individuos; ++i){
          m = i;
          for(j = i+1; j < individuos; ++j){
             if(aptitud[j] < aptitud[m]){
                m = j;
                }
             }
          int tempAptitud = aptitud[i];
          Cromosoma tempCromosoma = poblacion[i];
          aptitud[i] = aptitud[m];
          poblacion[i] = poblacion[m];
          aptitud[m] = tempAptitud;
          poblacion[m] = tempCromosoma;
       }
    }
    
    private Cromosoma mejor(){
       return poblacion[individuos-1];
    }
    
    public void run(){
       algoritmo();
    }
    
}
