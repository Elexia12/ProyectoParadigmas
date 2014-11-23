/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmo.genetico;

/**
 *
 * @author b17016
 */
public class Cromosoma {
    
    private String[][] cuadroMagico;
    private int dimension;
    private double numeroMagico;
    private static final int MAGICO = 5;
    private static final int PANDIGITAL = 10;
    private static final int IGUALDAD = 1;
    private static final double PROB_CRUCE = 0.95;
    private static final double PROB_MUTA = 0.05;
    
    public Cromosoma(int dimension){
        this.dimension = dimension;
        numeroMagico = 0;
        cuadroMagico = new String[dimension][dimension];
    }
    
    public double getNumeroMagico(){
       return numeroMagico;
    }
    
    public String[][] getCuadroMagico(){
       return cuadroMagico;
    }
    
    public void cruce(Cromosoma padre, Cromosoma madre){
       double prob = Math.random();
       if(prob < PROB_CRUCE){
          int orden = (int)(Math.random()*2+1);
          int indice = (int)(dimension/2);
          String[][] cuadroPadre = padre.getCuadroMagico();
          String[][] cuadroMadre = madre.getCuadroMagico();
          switch(orden){
              case 1:
                  if(dimension%2 == 0){
                     for(int i = 0; i < indice; ++i){
                        cuadroMagico[i] = cuadroPadre[i];
                     }
                     for(int i = indice; i < dimension; ++i){
                        cuadroMagico[i] = cuadroMadre[i];
                     }
                  }
                  else{
                     for(int i = 0; i < indice; ++i){
                        cuadroMagico[i] = cuadroPadre[i];
                     }
                     for(int i = indice; i < dimension; ++i){
                        cuadroMagico[i] = cuadroMadre[i];
                     } 
                     String genPadre = "";
                     String genMadre = "";
                     for(int i = 0; i < dimension; ++i){
                        genPadre = cuadroPadre[indice][i].substring(0,5);
                        genMadre = cuadroMadre[indice][i].substring(5);
                        cuadroMagico[indice][i] = hacerPandigital(genPadre+genMadre);
                     }
                  }
              break;
              case 2:
                  if(dimension%2 == 0){
                     for(int i = 0; i < indice; ++i){
                        cuadroMagico[i] = cuadroMadre[i];
                     }
                     for(int i = indice; i < dimension; ++i){
                        cuadroMagico[i] = cuadroPadre[i];
                     }
                  }
                  else{
                     for(int i = 0; i < indice; ++i){
                        cuadroMagico[i] = cuadroMadre[i];
                     }
                     for(int i = indice; i < dimension; ++i){
                        cuadroMagico[i] = cuadroPadre[i];
                     }
                     String genPadre = "";
                     String genMadre = "";
                     for(int i = 0; i < dimension; ++i){
                        genPadre = cuadroMadre[indice][i].substring(0,5);
                        genMadre = cuadroPadre[indice][i].substring(5);
                        cuadroMagico[indice][i] = hacerPandigital(genPadre+genMadre);
                     }
                  }
              break;
          }
       }
       else{
          int progenitor = (int)(Math.random()*2+1);
          switch(progenitor){
              case 1:
                  cuadroMagico = padre.getCuadroMagico();
              break;
              case 2:
                  cuadroMagico = madre.getCuadroMagico();
              break;
          }
       }
    }
    
    public void mutacion(){
       String temp = "";
       int x1 = (int)(Math.random()*dimension);
       int x2 = (int)(Math.random()*dimension);
       int y1 = (int)(Math.random()*dimension);
       int y2 = (int)(Math.random()*dimension);
       double prob = Math.random();
       if(prob < PROB_MUTA){
          temp = cuadroMagico[x1][y1];
          cuadroMagico[x1][y1] = cuadroMagico[x2][y2];
          cuadroMagico[x2][y2] = temp;
       }
    }
    
    private String hacerPandigital(String linea){
       String temp = "";
       boolean[] numeros = new boolean[10];
       for(int i = 0; i < 10; ++i){
          numeros[i] = true;
       }
       //revisa si es pandigital
       for(int i = 0; i < 10; ++i){
          numeros[Integer.parseInt(""+linea.charAt(i))] = false;
          if(!numeros[Integer.parseInt(""+linea.charAt(i))]){
             temp += "" + linea.charAt(i);
          }
          else{
             temp += "a";
          }
       }
       //lo hace pandigital
       for(int i = 0; i < 10; ++i){
          if(temp.charAt(i) == 'a'){
             String subparte = temp.substring(0, i+1);
             boolean termino = false;
             for(int j = 0; j < 10 && !termino; ++j){
                if(numeros[j]){
                   temp = "" + subparte + j + temp.substring(i+1);
                   numeros[j] = false;
                   termino = true;
                }
             }
          }
       }
       return temp;
    }
    
    public void generarCuadroMagico(){
       boolean[] numeros = new boolean[10];
       for(int i = 0; i < 10; ++i){
          numeros[i] = true;
       }
       String numero = "";
       int digito = 0;
       for(int i = 0; i < dimension; ++i){
          for(int j = 0; j < dimension; ++j){
             for(int x = 0; x < 10; ++x){
                //primer digito con restriccion != 0
                if(x == 0){
                   digito = (int)(Math.random()*9+1);
                   numeros[digito] = false;
                   numero = "" + digito;
                }
                // el resto de digitos
                else{
                   digito = (int)(Math.random()*(10-x)+1);
                   int contador = 0;
                   int pos = 0;
                   for(pos = 0; pos < 10 && contador < digito; ++pos){
                      if(numeros[pos]){
                         ++contador;
                      }
                   }
                   --pos;
                   numeros[pos] = false;
                   numero += "" + pos;
                }
             }
             cuadroMagico[i][j] = numero;
             for(int y = 0; y < 10; ++y){
                numeros[y] = true;
             }
          }
       }
    }
    
    public int calcularAptitud(){
       int aptitud = 1;
       double[] sumas = new double[2*dimension+2];
       int[] coincidencias = new int[2*dimension+2];
       double temp = 0;
       int pos = 0;
       String numero = "";
       String[] revision;
       boolean pandigital = true;
       boolean[] numeros = new boolean[10];
       for(int i = 0; i < 10; ++i){
          numeros[i] = true;
       }
       // suma filas
       for(int i = 0; i < dimension; ++i){
          for(int j = 0; j < dimension; ++j){
             temp += Double.parseDouble(cuadroMagico[i][j]);
          }
          sumas[i] = temp;
          temp = 0;
       }
       temp = 0;
       //sumas columnas
       for(int i = 0; i < dimension; ++i){
          for(int j = 0; j < dimension; ++j){
             temp += Double.parseDouble(cuadroMagico[i][j]);
          }
          sumas[dimension+i] = temp;
          temp = 0;
       }
       temp = 0;
       //suma diagonal izquierda-derecha
       for(int i = 0; i < dimension; ++i){
          temp += Double.parseDouble(cuadroMagico[i][i]);
       }
       temp = 0;
       //suma diagonal derecha-izquierda
       sumas[sumas.length-2] = temp;
       for(int i = dimension-1; i > -1; --i){
          temp += Double.parseDouble(cuadroMagico[i][i]);
       }
       //evaluar coincidencias
       temp = 0;
       for(int i = 0; i < 2*dimension+2; ++i){
          for(int j = i+1; j < 2*dimension+2; ++j){
             if(sumas[i] == sumas[j]){
                ++temp;
             }
          }
          coincidencias[i] = (int)(temp);
          temp = 0;
       }
       temp = 0;
       for(int i = 0; i < 2*dimension+2; ++i){
          if(coincidencias[i] < temp){
             temp = coincidencias[i];
             pos = i;
          }
       }
       numeroMagico = sumas[pos];
       aptitud += IGUALDAD*temp;
       //revisar si es cuadrado magico
       if(temp == 2*dimension+1){
          aptitud += MAGICO;
       }
       //revisar si es numero
       numero = ""+numeroMagico;
       revision = numero.split("E");
       if(revision[1].equalsIgnoreCase("9")){
          numero = ""+revision[0].charAt(0)+revision[0].substring(2);
          for(int i = 0; i < numero.length() && pandigital; ++i){
             if(numeros[Integer.parseInt(""+numero.charAt(i))]){
                numeros[Integer.parseInt(""+numero.charAt(i))] = false;
             }
             else{
                pandigital = false;
             }
          }
          if(pandigital){
             aptitud += PANDIGITAL;
          }
       }
       return aptitud;
    }
    
    public String imprimir(){
       String matriz = "";
       for(int i = 0; i < dimension; ++i){
          for(int j = 0; j< dimension; ++j){
             matriz += cuadroMagico[i][j] + "\t";
          }
          matriz += "\n";
       }
       return matriz;
    }
    
}
