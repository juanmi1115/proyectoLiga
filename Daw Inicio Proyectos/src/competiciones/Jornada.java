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

    public Jornada(int numeroJornada, Partido[] partido) {
        this.numeroJornada = numeroJornada;
        this.partido = partido;
    }

    public int getNumeroJornada() {
        return numeroJornada;
    }

    public Partido[] getPartido() {
        return partido;
    }

    public void setNumeroJornada(int numeroJornada) {
        this.numeroJornada = numeroJornada;
    }

    public void setPartido(Partido[] partido) {
        this.partido = partido;
    }
    
    public void simular(){
        for (int i = 0; i < this.partido.length; i++) {
            this.partido[i].simular();
        }
        
    }

    @Override
    public String toString() {
        String ret=" ";
        for (int i = 0; i < this.partido.length; i++){
            ret += this.partido[i].toString()+"\n";
            
        }
        return ret+"\n";
    }
     
}
