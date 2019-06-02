/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competiciones;

import equiposJugadores.Equipo;

/**
 * Clase Jornada.
 * Donde guardaremos cada jornada que se juegue en la liga.
 * @author juanmi
 */
public class Jornada {
    private int numeroJornada; //Aqui se guarda el número de la jornada en la que estamos.
    private Partido [] partido; //En este array guardaremos los partidos de la jornada.

    //Constructor de la clase Jornada
    public Jornada(int numeroJornada, Partido[] partido) {
        this.numeroJornada = numeroJornada;
        this.partido = partido;
    }

    //Getter de numeroJornada
    public int getNumeroJornada() {
        return numeroJornada;
    }

    //Getter de partido
    public Partido[] getPartido() {
        return partido;
    }

    //Setter de numeroJornada
    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }
    
    //Setter de Partido
    public void setPartido(Partido[] partido) {
        this.partido = partido;
    }
    
    //Función simular con ella recorremos todos los partidos de la jornada, los simulamos y los imprimimos
    public void simular(){
        for (int i = 0; i < this.partido.length; i++) {
            this.partido[i].simular();
        }
        
    }
    
    //Función tu toString para imprimir las jornadas.
    @Override
    public String toString() {
        String ret=" ";
        for (int i = 0; i < this.partido.length; i++){
            ret += this.partido[i].toString()+"\n";
            
        }
        return "JORNADA "+this.getNumeroJornada()+"\n"+"\n"+ret+"\n";
    }
     
}
